package edu.miu.eshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long shoppingCartId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "id")
    private List<ShoppingCartItem> shoppingCartItems;

    private LocalDate dateAdded;

    public ShoppingCart() {
    }

    public ShoppingCart(Long shoppingCartId, Customer customer, List<ShoppingCartItem> shoppingCartItems, LocalDate dateAdded) {
        this.shoppingCartId = shoppingCartId;
        this.customer = customer;
        this.shoppingCartItems = shoppingCartItems;
        this.dateAdded = dateAdded;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
