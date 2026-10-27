package com.jspl.JindalWorld.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Document(collection = "announcements")
public class Announcement {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false)
    private String title;

//    @Column(nullable = false, columnDefinition = "text")
    private String message;

//    @Column(nullable = false)
    private String audience = "All Entities";

//    @Column(nullable = false)
    private String priority = "normal";

//    @Column(name = "publish_date", nullable = false)
    private String publishDate;

//    @Column(nullable = false)
    private String status = "draft";

//    @Column(name = "redirect_url", columnDefinition = "text")
    private String redirectUrl;

//    @Column(name = "createdBy")
    private Integer createdBy;

//    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

//    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

//    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    public Announcement() {}

    // Generate getters and setters in your IDE.


}