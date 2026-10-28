
package com.jspl.JindalWorld;

import org.bson.Document;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoRuntimeInfo implements ApplicationRunner {

    private final MongoTemplate mongoTemplate;
    private final Environment environment;

    public MongoRuntimeInfo(
            MongoTemplate mongoTemplate,
            Environment environment) {
        this.mongoTemplate = mongoTemplate;
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Active profiles: "
                + String.join(", ", environment.getActiveProfiles()));

        System.out.println("Configured Mongo URI: "
                + environment.getProperty("spring.data.mongodb.uri"));

        System.out.println("MongoTemplate database: "
                + mongoTemplate.getDb().getName());

        mongoTemplate.executeCommand(new Document("ping", 1));
    }
}
