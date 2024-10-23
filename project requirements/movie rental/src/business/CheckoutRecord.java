package business;

import dataaccess.FileStorageUtil;

import java.io.Serializable;
import java.util.List;

public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private MemberUser member;
    private List<CheckoutEntry> checkoutEntries;

    public CheckoutRecord(MemberUser member) {
        this.member = member;
//        this.id = ;
//        this.checkoutEntries = checkoutEntries;
    }

    public void addCheckoutEntry(CheckoutEntry entry) {
        this.checkoutEntries.add(entry);
    }

    public int generateId() {
        List<CheckoutRecord> crlist = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.CHECKOUTRECORD);
        return 1;
    }

    public int getId() {
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
