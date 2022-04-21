package edu.miu.eshop.controller;

import edu.miu.eshop.DTO.ShoppingCartRequest;
import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;
import edu.miu.eshop.service.implementation.ShoppingCartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api", "api/shoppingCart"})
public class ShoppingCartController {
    private final ShoppingCartServiceImpl shoppingCartService;

    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping(value = "/addCartItem")
    public ShoppingCartItem addCartItem(@RequestBody ShoppingCartRequest request) {
        return this.shoppingCartService.addCartItem(request);
    }

    @PostMapping(value = "/updateQuantity")
    public void updateQuantity(Long shoppingCartId, Long productId, boolean isAdd) {
        this.shoppingCartService.updateQuantity(shoppingCartId, productId, isAdd);
    }

    @GetMapping(value = "/getShoppingCartDetails")
    public List<ShoppingCartItem> getShoppingCartDetails(Long shoppingCartId) {
        return this.shoppingCartService.getShoppingCartDetails(shoppingCartId);
    }
}
