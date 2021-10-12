package com.MBProject.SpringJpa.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {

    @GeneratedValue
    @Id
    private int p_id;

    private String productName;
    private int p_qty;

    public Product(String productName, int p_qty, int price) {
        this.productName = productName;
        this.p_qty = p_qty;
        this.price = price;
    }

    private int price;
}
