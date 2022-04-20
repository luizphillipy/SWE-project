package edu.miu.eshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDate dateCreated;
    @OneToMany
    @JoinColumn(name = "customerId")
    private Customer customer;
    private Integer status;
    @OneToMany
    @JoinColumn(name = "shoppingCartId")
    private List<ShoppingCartItem> shoppingCartItems;
    private Double Total;
}
