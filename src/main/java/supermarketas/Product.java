package supermarketas;

import java.util.ArrayList;

public class Product {

    private static int cntr = 0;
    private static ArrayList<Product> products = new ArrayList<Product>();
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        products.add(this);
        cntr++;
        setId(cntr);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getNameById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getName();
            }
        }
        return null;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static double getPriceById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static Product checkAvailability(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public String toString() {
        return String.format("Product [id=%d, name=%s, price=%.2f, available quantity=%d]",
                getId(),getName(), getPrice(), getQuantity());
    }

}


