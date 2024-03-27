package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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
    LocalDateTime redactedDate = new LocalDateTime("dd-MM-YYYY HH:mm");
    @Column(name = "createdDate")
    LocalDateTime  createdDate = new LocalDateTime("dd-MM-YYYY HH:mm");
}
