package apap.tutorial.minicommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "rating")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "rate", nullable = false)
    private Double rate;

    @NotNull
    @Column(name = "count", nullable = false)
    private Integer count;

    @OneToOne(mappedBy = "rating", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Item item;
}
