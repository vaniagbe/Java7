public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        initializePlatform(platform);

        // Simulate user interactions, cart updates, order placements, etc.
        simulateInteractions(platform);

        // Display the final state of users, products, and orders
        platform.displayFinalState();
    }

    private static void initializePlatform(ECommercePlatform platform) {
        Product product1 = new Product(1, "Laptop", 999.99, 50);
        Product product2 = new Product(2, "Smartphone", 499.99, 100);

        platform.addProduct(product1);
        platform.addProduct(product2);

        User user1 = new User(1, "john_doe");
        User user2 = new User(2, "jane_smith");

        platform.addUser(user1);
        platform.addUser(user2);
    }

    public static void simulateInteractions(ECommercePlatform platform) {
        User user1 = platform.getUsers().get(1);
        User user2 = platform.getUsers().get(2);

        Product laptop = platform.getProducts().get(1);
        Product smartphone = platform.getProducts().get(2);

        user1.addToCart(laptop, 2);
        user2.addToCart(smartphone, 1);

        platform.createOrder(1);
        platform.createOrder(2);

        user1.removeFromCart(laptop, 1);
        user2.modifyCart(smartphone, 3);
        platform.updateProductStock(laptop, 45);

        platform.listAvailableProducts();
    }
}