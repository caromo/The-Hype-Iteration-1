package sample;

public class Armor extends Equipment{
    private int Defense;
    public Armor(int ItemID, int EQID, int def) {
        super(ItemID, EQID);
        this.Defense = def;
    }

    @Override
    public int applyEffect() {
        return Defense;
    }

    @Override
    public int supplyBenefit() {
        return Defense;
    }
}
