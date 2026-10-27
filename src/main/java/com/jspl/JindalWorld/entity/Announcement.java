package com.jspl.JindalWorld.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Document(collection = "announcements")
public class Announcement {

    @Id
    private Integer id;

    private String title;

    private String message;

    private final String audience = "All Entities";

    private final String priority = "normal";

    private String publishDate;

    private final String status = "draft";

    private String redirectUrl;

    private Integer createdBy;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private OffsetDateTime deletedAt;


}