package resource;

import dto.ProductCategoryDTO;
import entity.ProductCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/product-category")
@Stateless
public class ProductCategoryResource {

@PersistenceContext
private EntityManager em;

    @GET
    public List<ProductCategoryDTO> findAll() {
        return em.createQuery("from ProductCategory", ProductCategory.class)
                .getResultList()
                .stream()
                .map(c -> new ProductCategoryDTO(
                        c.getId(),
                        c.getName()
                ))
                .collect(Collectors.toList());
    }

    @POST
    public ProductCategory save(ProductCategory category) {
        em.persist(category);
        return category;
    }

}
