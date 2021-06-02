package com.example.smartphone_shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "cart_id", nullable = false)
    private Cart cart;

}
