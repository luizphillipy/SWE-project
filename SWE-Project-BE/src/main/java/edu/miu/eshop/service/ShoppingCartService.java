package edu.miu.eshop.service;

import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart addCartItem(ShoppingCart shoppingCart);
    void updateQuantity(Long shoppingCartId, Long productId, int quantity);
    List<ShoppingCartItem> getShoppingCartDetails(Long shoppingCartId);
    Long getActiveShoppingCart(Long userId);
    Integer getShoppingCartItemsNumber(Long userId);
}
