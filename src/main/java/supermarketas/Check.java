package supermarketas;


import java.util.ArrayList;

public class Check {

    private static int cntr = 0;
    private static ArrayList<Check> checks = new ArrayList<Check>();
    private int id;
    private double cost;
    private ArrayList<int[]> pouch = new ArrayList<int[]>();
    private int items;

    public Check(Customer customer, ArrayList<int[]> pouch) {
        checks.add(this);
        cntr++;
        setId(cntr);
        setPouch(pouch);
        calculateCost();

    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setPouch(ArrayList<int[]> pouch) {
        this.pouch = pouch;
    }

    public ArrayList<int[]> getPouch() {
        return pouch;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getItems() {
        return items;
    }

    public void calculateCost() {
        ArrayList<Product> products = Product.getProducts();
        double price;
        double cost = 0;
        int quantity;
        for (int[] purchase : pouch) {
            for (Product product : products) {
                if (product.getId() == purchase[0]) {
                    price = product.getPrice();
                    quantity = purchase[1];
                    cost += price * quantity;
                    break;
                }
            }
        }
        setCost(cost);
    }

    public void setCost(double cst) {
        cost = Math.round(cst * 100.0) / 100.0;
    }

    public double getCost() {
        return cost;
    }

    public static ArrayList<Check> getCheks() {
        return checks;
    }

    public void printCheck() {
        System.out.printf("Check #%d#\n",getId());

        for (int[] purchase : pouch) {
            String name = Product.getNameById(purchase[0]);
            String price = Double.toString(Product.getPriceById(purchase[0]));
            int space = name.length() + price.length() + 6;
            int border = 50;
            int leave = border - space;
            System.out.printf("%-3s%s%7s","|",name,price);
            System.out.printf("%" + leave + "s\n","|");
            String quantity = Integer.toString(purchase[1]);
            String cost = Double.toString(Double.parseDouble(price) * purchase[1]);
            space = cost.length() + 12;
            leave = border - space;
            System.out.printf("%-8sx%-3s%s","|",quantity,cost);
            System.out.printf("%" + leave + "s\n","|");
        }
        String total = Double.toString(getCost());
        int space = total.length() + 9;
        int border = 50;
        int leave = border - space;
        System.out.printf("%-3sCost: %s","|",total);
        System.out.printf("%" + leave + "s\n","|");
    }

    public String toString() {
        return String.format("Total Cost: %f, "
                + "Bought items: %d", getCost(), getItems());
    }

}