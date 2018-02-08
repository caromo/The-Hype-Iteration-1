package sample;

public class Weapon extends Equipment {
    private int Attack;

    public Weapon(int ItemID, int EQID, int attack) {
        super(ItemID, EQID);
        this.Attack = attack;
    }

    @Override
    public int supplyBenefit() {
        return Attack;
    }
}
