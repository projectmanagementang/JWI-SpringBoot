package com.jspl.JindalWorld.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;


    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims validateToken(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateAccessToken(String username){

        long CurrentTimeMillies = System.currentTimeMillis();


        return Jwts.builder()
                        .subject(username)
                        .issuedAt(new Date(CurrentTimeMillies))
                        .expiration(new Date(CurrentTimeMillies + 900000))
                        .signWith(getSigningKey())
                        .compact();
    }


}
