//TODO: Impliment a way to equip gear effectively
package sample;

public class Armor extends Equipment{
    private int Defense;
    public Armor(int ItemID, int EQID, int def) {
        super(ItemID, EQID);
        this.Defense = def;
    }

}
