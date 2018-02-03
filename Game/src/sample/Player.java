package sample;

public class Player {
    private Inventory inventory;
    public Occupy occupy;
    public Player() {
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
