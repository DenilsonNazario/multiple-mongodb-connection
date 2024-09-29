package com.example.dev4j;

import com.example.dev4j.models.DealerModel;
import com.example.dev4j.models.VehicleModel;
import com.example.dev4j.services.DealerService;
import com.example.dev4j.services.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class Dev4jApplication implements CommandLineRunner {

    @Autowired
    private DealerService dealerService;
    @Autowired
    private VehicleService vehicleService;

    public static void main(String[] args) {
        SpringApplication.run(Dev4jApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //removing data
        dealerService.deleteAll();

        //insert
        log.info("inserting dealer ...");
        dealerService.insert(getDealer());

        //insert List
        log.info("inserting dealers List...");
        dealerService.insert(Collections.singletonList(getDealer()));

        //find all dealers
        log.info("find all dealers ...");
        List<DealerModel> dealerModels = dealerService.findAll();
        log.info("dealers {}", dealerModels);

        //find dealers by id
        log.info("find dealers by id {}", dealerModels.get(0).getId());
        DealerModel dealer = dealerService.findById(dealerModels.get(0).getId());
        log.info("dealer {}", dealer);

        //Vehicle

        //removing data
        vehicleService.deleteAll();

        //insert
        log.info("inserting vehicle ...");
        vehicleService.insert(getVehicle());

        //insert List
        log.info("inserting vehicles List ...");
        vehicleService.insert(Collections.singletonList(getVehicle()));

        //find all dealers
        log.info("find all vehicles");
        List<VehicleModel> vehicles = vehicleService.findAll();
        log.info("Vehicles {}", vehicles);

        //find by id
        log.info("find by id: {}", vehicles.get(0).getId());
        VehicleModel vehicle = vehicleService.findById(vehicles.get(0).getId());
        log.info("Vehicle {}", vehicle);

    }

    private DealerModel getDealer() {
        return DealerModel.builder()
                .id(UUID.randomUUID().toString())
                .document(UUID.randomUUID().toString())
                .name("Test")
                .build();
    }

    private VehicleModel getVehicle() {
        return VehicleModel.builder()
                .id(UUID.randomUUID().toString())
                .color("Black")
                .price("89,990.00")
                .build();
    }
}
