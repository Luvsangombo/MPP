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

    public CheckoutRecord(String id, MemberUser member) {
        this.member = member;
//        this.id = ;
//        this.checkoutEntries = checkoutEntries;
    }

    public void addCheckoutEntry(CheckoutEntry entry) {
        this.checkoutEntries.add(entry);
    }

    public String getId() {
        return id;
    }

    // Getters and Setters
    public MemberUser getMember() {
        return member;
    }

    public void setMember(MemberUser member) {
        this.member = member;
    }


}
