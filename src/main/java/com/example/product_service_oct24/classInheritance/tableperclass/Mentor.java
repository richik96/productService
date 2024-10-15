package com.example.product_service_oct24.classInheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tbc_mentor")

public class Mentor extends User{

    private double avgRating;
}
