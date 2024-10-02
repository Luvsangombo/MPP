package lab2.prob3.phone;

public class SimCard {
    private String number;
    private String line;

    private SimCard(CellPhone cellPhone, String line, String number) {
        this.number = number;
        this.line = line;
        cellPhone.setSimCard(this);
    }
    public static SimCard getSimCard(CellPhone cellPhone, String line, String number) {
        if (cellPhone == null) {
            return null;
        }
        return new SimCard(cellPhone, line, number);
    }

    public String getNumber() {
        return number;
    }

    public String getLine() {
        return line;
    }
}
