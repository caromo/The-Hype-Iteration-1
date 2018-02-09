// TODO: Figure out how to effectively represent a rings effect on the Player.
package sample;

// For simplicity, rings add to a player's health stat only!
public class Ring extends Equipment {
    private int HealthBoost;
    public Ring(int ItemID, int EQID, int HPBonus ) {
        super(ItemID, EQID);
        HealthBoost = HPBonus;
    }

    public int supplyBenefit() {
        return HealthBoost;
    }
}
