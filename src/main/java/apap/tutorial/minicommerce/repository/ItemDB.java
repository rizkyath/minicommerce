package apap.tutorial.minicommerce.repository;

import apap.tutorial.minicommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDB  extends JpaRepository<Item, Long> {
}
