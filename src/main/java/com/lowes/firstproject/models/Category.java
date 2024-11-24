package com.lowes.firstproject.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Category {


    @Id
    private int id;
    private  String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
