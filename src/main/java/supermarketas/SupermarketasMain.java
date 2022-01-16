package supermarketas;

public class SupermarketasMain {
    public static void main(String[] args) {

        createObjects();
        Meniu.welcomeMessage();
        Customer customer = null;
        while (customer == null) {
            String[] credentials = Meniu.getCredentials();
            customer = Meniu.checkingCredentials(credentials[0], credentials[1]);
            if (customer == null) {
                System.out.println("Wrong Combination. Try again.");
            }
            else {
                System.out.printf("Welcome *%s*\n\n", customer.getName());
                }
                Meniu.getMeniu(customer);
                }
        }

    private static void createObjects() {
        new Customer("Peasant Swineherd ", "peas", "1234");
        new Customer("Djinn Wishcatcher ", "djinn", "1333");
        new Product("Milk 1Lt", 1.99, 400);
        new Product("Schnitzel 350gr", 5.98, 70);
        new Product("Spaghetti 500gr", 1.07, 350);
        new Product("Juice 1Lt", 1.99, 400);
        new Product("Bread 350gr", 0.98, 70);
        new Product("Rise 1kg", 1.07, 350);
        }


    }

