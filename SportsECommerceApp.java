import java.util.ArrayList;
import java.util.Scanner;

// Product class to represent items in the store
class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". " + name + " - $" + price;
    }
}

// Main E-commerce Application
public class SportsECommerceApp {
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        // Adding some sample products to the store
        products.add(new Product(1, "Tennis ball", 4.99));
        products.add(new Product(2, "Basketball", 24.99));
        products.add(new Product(3, "Tennis Racket", 69.99));
        products.add(new Product(4, "Running Shoes", 49.99));
        products.add(new Product(5, "Baseball Bat", 34.99));
         products.add(new Product(6, "Soccer Ball", 19.99));
        products.add(new Product(7, "Boxing Gloves", 39.99));
        products.add(new Product(8, "Badminton Racket", 24.99));
        products.add(new Product(9, "Yoga Mat", 14.99));
        products.add(new Product(10, "Swimming Goggles", 12.99));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Sports E-Commerce Store!");

        while (running) {
            System.out.print("");
            System.out.print("********************************");
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("********************************");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for visiting the Sports E-Commerce Store!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to display all products
    public static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to add a product to the cart
    public static void addToCart(Scanner scanner) {
        System.out.println("\nEnter the product ID to add to cart:");
        int productId = scanner.nextInt();
        boolean found = false;

        for (Product product : products) {
            if (product.id == productId) {
                cart.add(product);
                System.out.println(product.name + " has been added to your cart.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found. Please try again.");
        }
    }

    // Method to view items in the cart
    public static void viewCart() {
        System.out.println("\nYour Cart:");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;
            for (Product product : cart) {
                System.out.println(product);
                total += product.price;
            }
            System.out.println("Total: $" + total);
        }
    }

    // Method to handle checkout
    public static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty. Add some products before checkout.");
        } else {
            double total = 0;
            System.out.println("\nCheckout:");
            for (Product product : cart) {
                System.out.println(product);
                total += product.price;
            }
            System.out.println("Total amount: $" + total);
            System.out.println("Thank you for your purchase!");
            cart.clear();
        }
    }
}
