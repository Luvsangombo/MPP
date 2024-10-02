package lab3.prob3;

abstract class Property {
    private Address address;
    Property(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    abstract double computeRent();
}
