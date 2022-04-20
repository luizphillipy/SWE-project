package edu.miu.eshop.service.implementation;

import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;
import edu.miu.eshop.repository.ShoppingCartItemRepository;
import edu.miu.eshop.repository.ShoppingCartRepository;
import edu.miu.eshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public ShoppingCart addCartItem(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void updateQuantity(Long shoppingCartId, Long productId, int quantity) {

       ShoppingCartItem shoppingCartItem = this.shoppingCartItemRepository.findByShoppingCartIdAndProductId(shoppingCartId, productId);
       shoppingCartItem.setQuantity(quantity);
       this.shoppingCartItemRepository.save(shoppingCartItem);
    }

    @Override
    public List<ShoppingCartItem> getShoppingCartDetails(Long shoppingCartId) {
        return this.shoppingCartItemRepository.findById(shoppingCartId).stream().toList();
    }

}
