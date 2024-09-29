package com.example.dev4j.services.impl;

import com.example.dev4j.models.VehicleModel;
import com.example.dev4j.services.VehicleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService {

    private final MongoTemplate mongoTemplate;

    public VehicleServiceImpl(@Qualifier("vehicleDBMongoTemplate") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(List<VehicleModel> models) {
        this.mongoTemplate.insert(models, "vehicles");
    }

    @Override
    public List<VehicleModel> findAll() {
        Query qry = new Query();
        qry.collation(Collation.of("en_US"));
        return this.mongoTemplate.find(qry, VehicleModel.class, "vehicles");
    }

    @Override
    public void insert(VehicleModel model) {
        this.mongoTemplate.insert(model, "vehicles");
    }

    @Override
    public VehicleModel findById(String id) {
        return this.mongoTemplate.findById(id, VehicleModel.class, "vehicles");
    }

    @Override
    public void deleteAll() {
        Query qry = new Query();
        qry.collation(Collation.of("en_US"));
        this.mongoTemplate.remove(qry, "vehicles");
    }
}
