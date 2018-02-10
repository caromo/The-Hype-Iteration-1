package sample;

public class Item extends tileObject{
    private int itemID;
    public int ScenarioID;

    public Item(int SN, int id) {
        super(SN);
        itemID = id;
    }

    public void useItem() {  }

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

//    @Override
//    public int getEffect() {
//        return itemID;
//
}
