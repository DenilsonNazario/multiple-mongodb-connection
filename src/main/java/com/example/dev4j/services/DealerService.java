package com.example.dev4j.services;

import com.example.dev4j.models.DealerModel;

import java.util.List;

public interface DealerService {

    void insert(List<DealerModel> models);

    List<DealerModel> findAll();

    void insert(DealerModel model);

    DealerModel findById(String id);

    void deleteAll();

}
