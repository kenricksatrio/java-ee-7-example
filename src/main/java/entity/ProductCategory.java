package entity;

import listener.TimestampEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(TimestampEntityListener.class)
@Cacheable
public class ProductCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> productSet;

    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @Temporal(TemporalType.TIME)
    private Date updatedAt;

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }

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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
