package com.jspl.JindalWorld.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "annoucements_for_entities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementForEntity {

    @Id
    private Integer id;

    private Integer announcementId;

    private Integer entityId;


}