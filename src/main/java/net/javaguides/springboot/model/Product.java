package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "about")
    private String about;

    @Column(name = "categories")
    private String categories;

    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;
    @Column(name = "redactedDate")
    SimpleDateFormat redactedDate = new SimpleDateFormat("dd-MM-YYYY HH:mm");
    @Column(name = "createdDate")
    SimpleDateFormat createdDate = new SimpleDateFormat("dd-MM-YYYY HH:mm");


}
