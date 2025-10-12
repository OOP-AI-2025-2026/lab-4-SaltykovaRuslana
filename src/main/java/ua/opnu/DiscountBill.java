package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullPrice;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.fullPrice = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        this.fullPrice += i.getPrice();

        if (this.regularCustomer && i.getDiscount() > 0.0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        if (this.regularCustomer) {
            return super.getTotal() - this.discountAmount;
        } else {
            return super.getTotal();
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
        } else {
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
