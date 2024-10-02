package lab2.prob3;


import lab2.prob3.Phone.CellPhone;
import lab2.prob3.Phone.SimCard;

class Main {
    public static void main(String[] args) {
        CellPhone c = new CellPhone("mark", "model");
        SimCard m =  SimCard.getSimCard(c,"mobicom", "99999999");
        System.out.println(c.simCard.getLine());
    }
}