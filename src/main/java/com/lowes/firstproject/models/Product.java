package com.lowes.firstproject.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {


            @Id
            private int id;
            private String name;

        @ManyToOne
         private Category category;
}
