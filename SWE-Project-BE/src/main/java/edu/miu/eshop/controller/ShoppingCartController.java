package edu.miu.eshop.controller;

import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;
import edu.miu.eshop.service.implementation.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    public ShoppingCart addCartItem(ShoppingCart item) {
        return this.shoppingCartService.addCartItem(item);
    }

    public void updateQuantity(Long shoppingCartId, Long productId, int quantity) {
        this.shoppingCartService.updateQuantity(shoppingCartId, productId, quantity);
    }

    public List<ShoppingCartItem> getShoppingCartDetails(Long shoppingCartId) {
        return this.shoppingCartService.getShoppingCartDetails(shoppingCartId);
    }
}
