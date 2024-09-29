package com.example.dev4j.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDealerConfig {

    @Primary
    @Bean(name = "dealerDBProperty")
    @ConfigurationProperties(prefix = "spring.data.mongodb-dealer")
    public MongoProperties getProperties(){
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "dealerDBMongoTemplate")
    public MongoTemplate getMongoTemplate(){
        return new MongoTemplate(
                getMongoDatabaseFactory(getProperties())
        );
    }

    @Primary
    @Bean(name = "dealerDBDatabaseFactory")
    public MongoDatabaseFactory getMongoDatabaseFactory(MongoProperties mongoProperties){
        return new SimpleMongoClientDatabaseFactory(
                mongoProperties.getUri()
        );
    }
}
