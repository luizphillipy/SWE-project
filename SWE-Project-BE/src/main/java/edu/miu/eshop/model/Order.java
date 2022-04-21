package edu.miu.eshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "shoppingCartId")
    private List<ShoppingCartItem> shoppingCartItems;

    private Double Total;
    private LocalDate dateCreated;

    public Order() {
    }

    public Order(Long orderId, Customer customer, List<ShoppingCartItem> shoppingCartItems, Double total, LocalDate dateCreated) {
        this.orderId = orderId;
        this.customer = customer;
        this.shoppingCartItems = shoppingCartItems;
        Total = total;
        this.dateCreated = dateCreated;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}