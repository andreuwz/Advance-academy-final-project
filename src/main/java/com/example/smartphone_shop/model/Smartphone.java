package com.example.smartphone_shop.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "smartphone_list")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String smartphoneName;

    @Column(nullable = false)
    private String smartphonePrice;

    @ManyToOne
    @JoinColumn(name= "cart_id")
    private Cart cart;

}
