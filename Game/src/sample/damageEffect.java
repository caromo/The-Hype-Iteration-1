package sample;

public class damageEffect extends AreaEffect{
    private int damageEffect;
    private boolean On;
//    private Holding holding;

    public damageEffect(int scenario, int duration, int damageEffect) {
        super(scenario, duration);
        setDamageEffect(damageEffect);
        while(isEffectOn())
        {
            holding.tile.occupy.player.takeDamage(getDamageEffect());
            System.out.format("%d", holding.tile.occupy.player.getHealth());
        }

    }

    public void setDamageEffect(int damageEffect) {
        this.damageEffect = damageEffect;
    }

    public int getDamageEffect() {
        return damageEffect;
    }
}
