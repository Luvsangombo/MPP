package business;

import java.io.Serializable;
import java.util.List;

public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public MemberUser getMember() {
        return member;
    }

    public void setMember(MemberUser member) {
        this.member = member;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
