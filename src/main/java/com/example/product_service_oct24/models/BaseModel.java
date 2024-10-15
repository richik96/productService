package com.example.product_service_oct24.models;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass

public class BaseModel {

    @Id
    private Long id;

    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;
}
