package lab2.prob3.phone;

public class CellPhone {
    private String mark;
    private String model;
    public SimCard simCard;

    public CellPhone(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }
    public SimCard getSimCard() {
        return simCard;
    }

    public String getModel() {
        return model;
    }

    public String getMark() {
        return mark;
    }
}
