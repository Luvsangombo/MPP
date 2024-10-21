package business;

import java.util.List;

public class CheckoutRecord {
    private MemberUser member;
    private double totalAmount;
    private List<CheckoutEntry> checkoutEntries;

    public CheckoutRecord(MemberUser member, double totalAmount, List<CheckoutEntry> checkoutEntries) {
        this.member = member;
        this.totalAmount = totalAmount;
        this.checkoutEntries = checkoutEntries;
    }

    public void addCheckoutEntry(CheckoutEntry entry) {
        this.checkoutEntries.add(entry);
    }

    // Getters and Setters
}
