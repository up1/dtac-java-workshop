package parking_lot.model;

public class AvailableParkingLot {

    private int level;
    private int amount;

    public AvailableParkingLot(int level, int amount) {
        this.level = level;
        this.amount = amount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
