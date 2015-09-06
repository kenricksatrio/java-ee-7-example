package bean;

import entity.Product;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@SessionScoped
public class User implements Serializable {

    /**
     * key = product id
     * value = quantity dari product yang dimasukan ke cart
     * */
    private Map<Integer, Integer> cart = new LinkedHashMap<>();

    //dan ditambahkan field2 lain untuk user yang sedang login


    public Map<Integer, Integer> getCart() {
        return cart;
    }

    public void addToCart(int productId, int qty) {
        if(cart.containsKey(productId)) {
            cart.put(productId, cart.get(productId) + qty);
        } else {
            cart.put(productId, qty);
        }
    }

    public void updateCart(int productId, int qty) {
        cart.put(productId, qty);
    }

    public void removeFromCart(int productId) {
        this.cart.remove(productId);
    }

    public void clearCart() {
        this.cart.clear();
    }

}
