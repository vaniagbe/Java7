import java.util.HashMap;
import java.util.Map;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    // Methods for adding users, products, creating orders, listing items, updating stock
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId) {
        User user = users.get(userId);
        if (user != null && !user.getCart().isEmpty()) {
            Order order = new Order(orders.size() + 1, userId);
            user.getCart().forEach(order::addProductToOrder);
            orders.put(order.getId(), order);
            user.getCart().clear();
        }
    }

    public void listAvailableProducts() {
        products.values().forEach(System.out::println);
    }

    public void updateProductStock(Product product, int newStock) {
        Product existingProduct = products.get(product.getId());
        if (existingProduct != null) {
            existingProduct.setStock(newStock);
        }
    }

    // Other methods as needed
    public void displayFinalState() {
        System.out.println("Final State:");
        System.out.println("Users:");
        users.values().forEach(System.out::println);
        System.out.println("Products:");
        products.values().forEach(System.out::println);
        System.out.println("Orders:");
        orders.values().forEach(System.out::println);
    }


    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }


    public Map<Integer, Order> getOrders() {
        return orders;
    }
}