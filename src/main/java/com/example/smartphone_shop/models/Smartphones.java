package com.example.smartphone_shop.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Smartphone_list")
public class Smartphones {

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
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
