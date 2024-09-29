package com.example.dev4j.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "dealers")
@Data
@Builder
public class DealerModel {

    @Id
    private String id;
    private String document;
    private String name;
}
