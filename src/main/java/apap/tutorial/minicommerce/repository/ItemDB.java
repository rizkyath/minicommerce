package apap.tutorial.minicommerce.repository;

import apap.tutorial.minicommerce.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDB  extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.title LIKE %:title%")
    List<Item> findByFilterTitle(@Param("title") String title);
}
