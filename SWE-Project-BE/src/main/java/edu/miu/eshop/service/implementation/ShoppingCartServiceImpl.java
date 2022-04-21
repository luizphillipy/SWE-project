package edu.miu.eshop.service.implementation;

import edu.miu.eshop.DTO.ShoppingCartRequest;
import edu.miu.eshop.model.ShoppingCart;
import edu.miu.eshop.model.ShoppingCartItem;
import edu.miu.eshop.repository.ShoppingCartItemRepository;
import edu.miu.eshop.repository.ShoppingCartRepository;
import edu.miu.eshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public ShoppingCart addCartItem(ShoppingCartRequest request) {
//        return this.shoppingCartRepository.save(shoppingCart);
        return null;
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

    @Override
    public Long getActiveShoppingCartId(Long userId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findAll().stream().filter(x -> x.getCustomer().getCustomerId() == userId).findFirst().orElseGet(() -> null);

        if (shoppingCart != null) {
            return shoppingCart.getShoppingCartId();
        }

        return null;
    }

    @Override
    public Integer getShoppingCartItemsNumber(Long shoppingCartId) {
        List<ShoppingCartItem> shoppingCartItems = this.shoppingCartItemRepository.findAll().stream().filter(x -> x.getShoppingCart().getShoppingCartId() == shoppingCartId).collect(Collectors.toList());

        if (shoppingCartItems.size() > 0) return shoppingCartItems.size();

        return 0;
    }
}
