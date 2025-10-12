package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullPrice;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.fullPrice = 0.0;
    }

    public Employee getClerk() {
        return this.bill.getClerk();
    }

    public void add(Item i) {
        this.bill.add(i);
        this.fullPrice += i.getPrice();

        if (this.regularCustomer && i.getDiscount() > 0.0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        if (this.regularCustomer) {
            return this.bill.getTotal() - this.discountAmount;
        } else {
            return this.bill.getTotal();
        }
    }

    public int getDiscountCount() {
        if (this.regularCustomer) {
            return this.discountCount;
        } else {
            return 0;
        }
    }

    public double getDiscountAmount() {
        if (this.regularCustomer) {
            return this.discountAmount;
        } else  {
            return 0.0;
        }
    }

    public double getDiscountPercent() {
        if (this.regularCustomer && this.fullPrice > 0) {
            return 100.0 * this.discountAmount / this.fullPrice;
        } else {
            return 0.0;
        }
    }
}
