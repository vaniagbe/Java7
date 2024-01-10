import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0.0;
    }

    // Getters and setters

    public void addProductToOrder(Product product, int quantity) {
        if (orderDetails.containsKey(product)) {
            orderDetails.put(product, orderDetails.get(product) + quantity);
        } else {
            orderDetails.put(product, quantity);
        }
    }

    public double calculateTotalPrice() {
        totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }
}