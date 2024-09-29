package com.example.dev4j.services.impl;

import com.example.dev4j.models.DealerModel;
import com.example.dev4j.services.DealerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealerServiceImpl implements DealerService {

    private final MongoTemplate mongoTemplate;

    public DealerServiceImpl (@Qualifier("dealerDBMongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(List<DealerModel> models) {
        this.mongoTemplate.insert(models, "dealers");
    }

    @Override
    public List<DealerModel> findAll() {
        Query qry = new Query();
        qry.collation(Collation.of("en_US"));
        return this.mongoTemplate.find(qry, DealerModel.class, "dealers");
    }

    @Override
    public void insert(DealerModel model) {
        this.mongoTemplate.insert(model, "dealers");
    }

    @Override
    public DealerModel findById(String id) {
        return this.mongoTemplate.findById(id, DealerModel.class, "dealers");
    }

    @Override
    public void deleteAll() {
        Query qry = new Query();
        qry.collation(Collation.of("en_US"));
        this.mongoTemplate.remove(qry, "dealers");
    }
}
