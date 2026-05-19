package com.stschool.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(
            mappedBy="order",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY
    )

    private Payment payment;


}
