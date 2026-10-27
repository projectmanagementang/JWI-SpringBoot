package com.jspl.JindalWorld.service;


import com.jspl.JindalWorld.dto.LoginRequest;
import com.jspl.JindalWorld.dto.LoginResponse;
import com.jspl.JindalWorld.entity.UserAccount;
import com.jspl.JindalWorld.mapper.UserAccountMapper;
import com.jspl.JindalWorld.repository.UserAccountRepository;
import com.jspl.JindalWorld.security.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

@Service
public class AuthService {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    private final MongoTemplate mongoTemplate;

    private final UserAccountRepository userAccountRepository;
    private final UserAccountMapper userAccountMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(MongoTemplate mongoTemplate, UserAccountRepository userAccountRepository, UserAccountMapper userAccountMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.mongoTemplate = mongoTemplate;
        this.userAccountRepository = userAccountRepository;
        this.userAccountMapper = userAccountMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


        public LoginResponse login (LoginRequest loginRequest){

            System.out.println("Mongo URI: " + mongoUri);
            System.out.println("Connected database: " + mongoTemplate.getDb().getName());


            System.out.println("1. login service reach");
            System.out.println("Email received: " + loginRequest.email());

            UserAccount user;
            System.out.println(
                    "Connected database: " + mongoTemplate.getDb().getName()
            );

            System.out.println(
                    "Documents in user_accounts: "
                            + mongoTemplate.getCollection("user_accounts").countDocuments()
            );

            System.out.println(
                    "Matching email count: "
                            + mongoTemplate.getCollection("user_accounts")
                            .countDocuments(
                                    new org.bson.Document(
                                            "email", loginRequest.email()
                                    )
                            )
            );


            try {
                var optionalUser =
                        userAccountRepository.findByEmail(loginRequest.email());

                System.out.println("2. Repository lookup completed");
                System.out.println("3. User found: " + optionalUser.isPresent());

                user = optionalUser.orElseThrow(() ->
                        new BadCredentialsException("Invalid email or password"));

            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }


//                user = userAccountRepository
//                    .findByEmail(loginRequest.email())
//                    .orElseThrow(() ->
//                            new BadCredentialsException("Invalid email or password"));

            System.out.println("2. User found: " + user.getEmail());

            System.out.println("3. Password matches: "
                    + passwordEncoder.matches(loginRequest.password(), user.getPassword()));

            if (!passwordEncoder.matches(loginRequest.password() , user.getPassword())){
                throw new BadCredentialsException("Invalid email or password");
            }

            if (!"active".equalsIgnoreCase(user.getStatus())
            || user.getDeletedAt() != null){
                throw new BadCredentialsException("Invalid email or password");
            }

            String accessToken = jwtService.generateAccessToken(user.getEmail());
            System.out.println("4. Token generated");

            return new LoginResponse(
                    accessToken,
                    "Bearer",
                    userAccountMapper.toResponse(user)
            );
        }

}
