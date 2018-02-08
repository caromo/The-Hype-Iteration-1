package sample;

public class healingEffect extends AreaEffect{
    private int healingEffect;
    private boolean On;
//    private Holding holding;

    public healingEffect(int scenario, int duration, int healingEffect) {
        super(scenario, duration);
        setHealingEffect(healingEffect);
        while(isEffectOn())
        {
            holding.tile.occupy.player.setHealth(holding.tile.occupy.player.getHealth() + getHealingEffect());
            System.out.format("%d", holding.tile.occupy.player.getHealth());
        }


    }

    public int getHealingEffect() {
        return healingEffect;
    }

    public void setHealingEffect(int healingEffect) {
        this.healingEffect = healingEffect;
    }
}
