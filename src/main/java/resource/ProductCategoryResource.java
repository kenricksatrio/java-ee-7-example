package resource;

import dto.ProductCategoryDTO;
import entity.ProductCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
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
                .setHint("org.hibernate.cacheable", true)
                .getResultList()
                .stream()
                .map(c -> new ProductCategoryDTO(
                        c.getId(),
                        c.getName()
                ))
                .collect(Collectors.toList());
    }

    @POST
    public ProductCategoryDTO save(ProductCategoryDTO newCategory) {

        ProductCategory category = new ProductCategory(newCategory.getName());
        em.persist(category);

        newCategory.setId(category.getId());

        return newCategory;
    }

    @PUT
    @Path("/{id}")
    public void delete(@PathParam("id") Integer categoryId) {

        ProductCategory category = em.find(ProductCategory.class, categoryId);
        em.remove(category);
    }

}