package com.jspl.JindalWorld.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Document(collection = "news_items")
public class NewsItem {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tag;

//    @Column(name = "tag_color")
    private String tagColor;

//    @Column(nullable = false)
    private String title;

//    @Column(nullable = false, columnDefinition = "text")
    private String description;

//    @Column(nullable = false)
    private Integer likes = 0;

//    @Column(nullable = false, columnDefinition = "text")
    private String image;

//    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

//    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

//    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    public NewsItem() {}

    // Generate getters and setters in your IDE.


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(OffsetDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}