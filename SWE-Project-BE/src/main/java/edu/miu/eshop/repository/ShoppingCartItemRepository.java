package edu.miu.eshop.repository;

import edu.miu.eshop.model.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {

    @Query("select s from ShoppingCartItem s where s.shoppingCartId= ?1 and s.productId= ?2")
    ShoppingCartItem findByShoppingCartIdAndProductId(Long shoppingCartId, Long productId);
}
