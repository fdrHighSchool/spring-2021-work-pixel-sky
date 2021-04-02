import java.util.ArrayList;

/**
    The ShoppingCart class has an ArrayList of Items.
    You will write a new class DiscountedItem that extends Item.
    This code is adapted from https://practiceit.cs.washington.edu/problem/view/bjp4/chapter9/e10-DiscountBill
*/

public class Cart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Item("bread", 3.25));
        cart.add(new Item("milk", 2.50));

        // Uncomment these to test
        cart.add(new DiscountedItem("ice cream", 4.50, 1.50));
        cart.add(new DiscountedItem("apples", 1.35, 0.25));

        cart.printOrder();
    }
}

// DiscountedItem inherits from Item
class DiscountedItem extends Item {
    // add an instance variable for the discount
    double discountAmount;

    // Add constructors that call the super constructor
    public DiscountedItem(String name, double price, double discount) {
        super(name, price);
        this.discountAmount = discount;
    }
    
    // Add get/set methods for discount
    public void setDiscountAmount(double discount) {
        this.discountAmount = discount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    // Add a toString() method that returns a call to the super toString
    // and then the discount in parentheses using the super.valueToString() method
    @Override
    public String toString() {
        return super.toString() + "(-" +super.valueToString(this.discountAmount) + ")";
    }
}

class ShoppingCart {
    private ArrayList<Item> order;
    private double total;
    private double internalDiscount;

    public ShoppingCart() {
        this.order = new ArrayList<Item>();
        this.total = 0.0;
        this.internalDiscount = 0.0;
    }

    public void add(Item i) {
        this.order.add(i);
        this.total += i.getPrice();
        if (i instanceof DiscountedItem)
            this.internalDiscount += ((DiscountedItem) i).getDiscountAmount();
    }

    /** printOrder() will call toString() to print */
    public void printOrder() {
        System.out.println(this);
    }

    public String toString() {
        return discountToString();
    }

    public String discountToString() {
        return orderToString() + "\nSub-total: " + valueToString(this.total) + "\nDiscount: " + valueToString(this.internalDiscount) + "\nTotal: " + valueToString(this.total - this.internalDiscount);
    }

    private String valueToString(double value) {
        value = Math.rint(value * 100) / 100.0;
        String result = "" + Math.abs(value);
        if(result.indexOf(".") == result.length() - 2) {
            result += "0";
        }
        result = "$" + result;
        return result;
    }

    public String orderToString() {
        String build = "\nOrder Items:\n";
        for(int i = 0; i < order.size(); i++) {
            build += "   " + order.get(i);
            if(i != order.size() - 1) {
                build += "\n";
            }
        }
        return build;
    }
}

class Item {
    private String name;
    private double price;

    public Item() {
        this.name = "";
        this.price = 0.0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String valueToString(double value) {
        String result = "" + Math.abs(value);
        if(result.indexOf(".") == result.length() - 2) {
            result += "0";
        }
        result = "$" + result;
        return result;
    }

    public String toString() {
        return this.name + " " + valueToString(this.price);
    }
}
    