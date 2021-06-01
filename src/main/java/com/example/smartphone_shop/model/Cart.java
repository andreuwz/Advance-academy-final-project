package com.example.smartphone_shop.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "purchased_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cartName;

    @OneToOne
    private User users;

    @OneToMany(mappedBy = "cart")
    private List<Smartphone> smartphones;


}
