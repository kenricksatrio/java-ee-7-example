package resource;

import dto.ProductDTO;
import entity.Product;
import entity.ProductCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
                .getResultList()
                .stream()
                .map(p ->  new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getCategory().getName()))
                .collect(Collectors.toList());
    }

    @POST
    @Produces("application/json")
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer productId) {
        Product product = em.find(Product.class, productId);
        em.remove(product);
    }

}
