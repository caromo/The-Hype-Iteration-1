package sample;

public class Item extends tileObject{
    private int itemID;
    private boolean oneShot;
    public int ScenarioID;

    public Item(int SN, int id) {
        super(SN);
        itemID = id;
        oneShot = false;
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

    public void use() {}

    public boolean isOneShot() {
        return oneShot;
    }

    public void setOneShot(boolean oneShot) {
        this.oneShot = oneShot;
    }

//    @Override
//    public int getEffect() {
//        return itemID;
//
}
