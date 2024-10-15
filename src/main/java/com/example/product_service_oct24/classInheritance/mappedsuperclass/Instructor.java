package com.example.product_service_oct24.classInheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "ms_instructor")

public class Instructor extends User{

    private String favouriteStudent;

}
