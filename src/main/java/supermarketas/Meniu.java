package supermarketas;

import java.util.ArrayList;
import java.util.Scanner;

public class Meniu {
    public static void welcomeMessage() {
        System.out.printf("---DJINN SUPERMARKETAS---\n"
                + "Log in to continue\n");
    }

    public static String[] getCredentials() {
        Scanner input = new Scanner(System.in);
        String[] credentials = new String[2];
        System.out.print("Username: ");
        credentials[0] = input.nextLine();
        System.out.printf("Password: ");
        credentials[1] = input.nextLine();
        return credentials;
    }

    public static Customer checkingCredentials(String username, String password) {
        ArrayList<Customer> customers = Customer.getCustomers();
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)
                    && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public static void getMeniu(Customer customer) {
        Scanner input = new Scanner(System.in);
        System.out.printf("** Meniu **\n"
                + "1. Change Password\n"
                + "2. Print Products\n"
                + "3. Buy Products\n"
                + "Make a choice: " +
                "-1 print's Check ");

        int choice = input.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                changeUserPassword(customer);
                break;
            case 2:
                printProducts();
                break;
            case 3:
                buyProducts(customer);
                break;
            default:
                System.out.println("Not a valid choice.");
        }
    }


    public static void changeUserPassword(Customer customer) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type new password: ");
        String password1 = input.nextLine();
        System.out.print("Type it again: ");
        String password2 = input.nextLine();
        customer.changePassword(password1, password2);
    }

    public static void printProducts() {
        ArrayList<Product> products = Product.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void buyProducts(Customer customer) {
        int id;
        int quantity;
        int totalQuantity = 0;
        Product product;
        ArrayList<int[]> pouch = new ArrayList<int[]>();
        Scanner input = new Scanner(System.in);

        while (true) {
            int[] purchase = new int[2];
            System.out.print("Type product id: ");
            id = input.nextInt();
            if (id == -1) {
                break;
            }
            product = Product.checkAvailability(id);
            if (product == null) {
                System.out.print("Product with id " + id + " does not exist. ");
                System.out.println("Try again.");
            } else if (product.getQuantity() == 0) {
                System.out.println("Product " + product.getName() + " is not available");
            } else {
                while (true) {
                    System.out.print("Quantity: ");
                    quantity = input.nextInt();
                    if (quantity <= product.getQuantity()) {
                        purchase[0] = id;
                        purchase[1] = quantity;
                        pouch.add(purchase);
                        product.setQuantity(product.getQuantity() - quantity);
                        totalQuantity += quantity;
                        break;
                    } else {
                        System.out.printf("Not enough stock. ");
                        System.out.println("Stock: " + product.getQuantity() + " pieces.");
                    }
                }
            }
        }
            Check check = new Check(customer, pouch);
            check.printCheck();
            check.setItems(totalQuantity);
            System.out.printf("Total cost: %.2f\n\n", check.getCost());
        }


    public static void printPrevTransactions(Customer customer) {
        ArrayList<Check> checks = Check.getCheks();
        for (Check check : checks) {
            if (check.getPouch().equals(customer)) {
                System.out.println(check);
            }
        }
    }
}


