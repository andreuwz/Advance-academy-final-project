package com.example.smartphone_shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Purchased_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cartName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(nullable = false, name = "Smartphone_name")
    private Set<Smartphones> smartphones;


}
