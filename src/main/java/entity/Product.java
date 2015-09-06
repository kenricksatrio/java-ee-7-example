package entity;

import listener.TimestampEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(TimestampEntityListener.class)
@Cacheable
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 5)
    @NotNull(message = "product name is required")
    private String name;

    @Min(value = 1000, message = "minimum price is 1000")
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "product category is required")
    private ProductCategory  category;

    @OneToMany(mappedBy = "product")
    private Set<TransactionDetail> transactonDetails;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
