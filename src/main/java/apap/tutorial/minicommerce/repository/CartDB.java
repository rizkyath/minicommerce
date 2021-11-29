package apap.tutorial.minicommerce.repository;

import apap.tutorial.minicommerce.model.Cart;
import apap.tutorial.minicommerce.model.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDB  extends JpaRepository<Cart, Long> {
    Optional<Cart> findByItem(Item item);
}
