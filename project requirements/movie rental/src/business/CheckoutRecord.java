package business;

import dataaccess.FileStorageUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private MemberUser member;
    private List<CheckoutEntry> checkoutEntries;
    private double price;
    public boolean isReturned = false;

    public CheckoutRecord(String id, MemberUser member, List<CheckoutEntry> checkoutEntries) {
        this.member = member;
        this.id = id;
        this.checkoutEntries = checkoutEntries;

    }
    public void checking(){
        increaseQuantity();
        this.isReturned = true;
    }
    public String getId() {
        return id;
    }

    // Getters and Setters
    public MemberUser getMember() {
        return member;
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void decreaseQuantity(){
        checkoutEntries.forEach((entry)->{
           Movie old = FileStorageUtil.getObject(entry.getMovie().getId(), FileStorageUtil.StorageType.MOVIES);
           old.setQuantity(old.getQuantity()-1);
           FileStorageUtil.saveObject(old.getId(), old, FileStorageUtil.StorageType.MOVIES);
        });
    }

    public void increaseQuantity(){
        checkoutEntries.forEach((entry)->{
            Movie old =  FileStorageUtil.getObject(entry.getMovie().getId(), FileStorageUtil.StorageType.MOVIES);
            old.setQuantity(old.getQuantity()+1);
            FileStorageUtil.saveObject(old.getId(), old, FileStorageUtil.StorageType.MOVIES);
        });

    }
}
