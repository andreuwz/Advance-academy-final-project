package com.example.smartphone_shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String cartName;

    @OneToOne(mappedBy = "cart")
    private User user;

    private LocalDateTime cartCreationDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Smartphone> smartphone;

}
