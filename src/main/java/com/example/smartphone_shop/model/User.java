package com.example.smartphone_shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_list")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true,nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    private LocalDateTime userCreationDate;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

}
