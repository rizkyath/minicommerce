package apap.tutorial.minicommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "item")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @Size(max = 255)
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Size(max = 50)
    @Column(name = "category", nullable = false)
    private String category;

    @NotNull
    @Size(max = 255)
    @Column(name = "image", nullable = false)
    private String image;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rating", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rating rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
