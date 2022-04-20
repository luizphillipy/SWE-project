package edu.miu.eshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long shoppingCartId;
    @OneToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;
    private LocalDate dateAdded;
    @OneToMany
    private List<ShoppingCartItem> shoppingCartItems;
}
