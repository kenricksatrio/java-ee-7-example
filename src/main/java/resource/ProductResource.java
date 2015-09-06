package resource;

import dto.ProductCategoryDTO;
import dto.ProductDTO;
import entity.Product;
import entity.ProductCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path("/product")
public class ProductResource {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<ProductDTO> findAll() {

        return em.createQuery("from Product", Product.class)
                .setHint("org.hibernate.cacheable", true)
                .getResultList()
                .stream()
                .map(p -> new ProductDTO(
                                p.getId(),
                                p.getName(),
                                p.getPrice(),
                                new ProductCategoryDTO(
                                        p.getCategory().getId(),
                                        p.getCategory().getName()
                                ))
                )
                .collect(Collectors.toList());
    }

    @POST
    @Produces("application/json")
    public ProductDTO save(@Valid Product product) {

        em.persist(product);

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new ProductCategoryDTO(
                        product.getCategory().getId(),
                        product.getCategory().getName()
                )
        );
    }

    @PUT
    @Path("/{id}")
    public ProductDTO update(@Valid ProductDTO newProduct) {

        Product oldProduct = em.find(Product.class, newProduct.getId());
        ProductCategory category = em.find(ProductCategory.class, newProduct.getCategory().getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(category);

        return newProduct;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer productId) {

        Product product = em.find(Product.class, productId);
        em.remove(product);
    }

}
