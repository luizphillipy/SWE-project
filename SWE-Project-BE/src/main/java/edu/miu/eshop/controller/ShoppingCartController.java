package edu.miu.eshop.controller;

import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;
import edu.miu.eshop.service.implementation.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api", "api/shoppingCart"})
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @GetMapping(value = "/addCartItem")
    public ShoppingCart addCartItem(ShoppingCart item) {
        return this.shoppingCartService.addCartItem(item);
    }

    @GetMapping(value = "/updateQuantity")
    public void updateQuantity(Long shoppingCartId, Long productId, int quantity) {
        this.shoppingCartService.updateQuantity(shoppingCartId, productId, quantity);
    }

    @GetMapping(value = "/getShoppingCartDetails")
    public List<ShoppingCartItem> getShoppingCartDetails(Long shoppingCartId) {
        return this.shoppingCartService.getShoppingCartDetails(shoppingCartId);
    }
}
