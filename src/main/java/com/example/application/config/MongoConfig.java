package com.example.application.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${mongodb.connection-uri}")
    private String connectionUri;

    @Value("${mongodb.database}")
    private String database;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(connectionUri);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, database);
    }
}
