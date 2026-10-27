package com.jspl.JindalWorld.dto;

import java.time.OffsetDateTime;

public class UsertAccountResponse {


    private Integer id;

    private String name;

    private String email;

    private String entityId;

    private String departmentId;

    private String password;

    private final String status = "active";

    private String avatar;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private OffsetDateTime deletedAt;



}
