import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    // Getters and setters

    public void addToCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
    }

    public void removeFromCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            if (currentQuantity <= quantity) {
                cart.remove(product);
            } else {
                cart.put(product, currentQuantity - quantity);
            }
        }
    }

    public void modifyCart(Product product, int newQuantity) {
        if (newQuantity > 0) {
            cart.put(product, newQuantity);
        } else {
            cart.remove(product);
        }
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
}