package apap.tutorial.minicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tutorial.minicommerce.model.Rating;

@Repository
public interface RatingDB extends JpaRepository<Rating, Long> {
}