package com.jspl.JindalWorld.dto;

public record LoginResponse(String accessToken , String tokenType , UsertAccountResponse user) {
}
