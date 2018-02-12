package sample;

public class Item extends tileObject{
    private int itemID;
    private boolean oneShot;
    public int ScenarioID;
    private int requiredLevel;

    public Item(int SN, int id) {
        super(SN);
        itemID = id;
        oneShot = true;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getID() {
        return itemID;
    }

    public void printID() {
        System.out.println(itemID);
    }

    @Override
    public int getEffect() {
        return itemID;
    }

    public boolean isOneShot() {
        return oneShot;
    }

    public void setOneShot(boolean oneShot) {
        this.oneShot = oneShot;
    }
}
