package supermarketas;

import java.util.ArrayList;

public class Customer {
    private static int cntr = 0;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private int id;
    private String name;
    private String username;
    private String password;

    public Customer(String name, String username, String password) {
        customers.add(this);
        cntr++;
        setId(cntr);
        setName(name);
        setUsername(username);
        setPassword(password);
    }

    public int getCounter() {
        return cntr;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            setPassword(pass1);
            System.out.printf("Password has been changed.\n\n");
        } else {
            System.out.printf("Passwords don't match.\n\n");
        }
    }
}
