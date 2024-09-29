package com.example.dev4j.services;

import com.example.dev4j.models.VehicleModel;

import java.util.List;

public interface VehicleService {

    void insert(List<VehicleModel> models);

    List<VehicleModel> findAll();

    void insert(VehicleModel model);

    VehicleModel findById(String id);

    void deleteAll();
}
