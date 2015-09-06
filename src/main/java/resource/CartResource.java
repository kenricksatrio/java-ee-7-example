package resource;

import bean.User;
import dto.ProductCartDTO;
import entity.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/cart")
@Stateless
public class CartResource {

    @Inject
    private User user;

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<ProductCartDTO> findAll() {

        Map<Integer, Integer> cart = user.getCart();

        List<ProductCartDTO> response = new ArrayList<>(cart.size());

        for (Map.Entry<Integer, Integer> cartEntry : cart.entrySet()) {

            Product product = em.find(Product.class, cartEntry.getKey());
            response.add(new ProductCartDTO(
                    product.getId(),
                    product.getName(),
                    product.getCategory().getName(),
                    product.getPrice(),
                    cartEntry.getValue()
            ));
        }

        return response;
    }

    @POST
    @Path("/{productId}")
    public void addToCart(
            @PathParam("productId") int productId,
            int quantity) {

        user.addToCart(productId, quantity);
    }

    @PUT
    @Path("/{productId}")
    public void update(
            @PathParam("productId") int productId,
            int qty) {

        user.updateCart(productId, qty);
    }

    @DELETE
    public void clear() {

        user.clearCart();
    }

    @DELETE
    @Path("/{productId}")
    public void remove(
            @PathParam("productId") int productId) {

        user.removeFromCart(productId);
    }

}
