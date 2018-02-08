package sample;

public class expEffect extends AreaEffect{
    private int expEffect;
    private boolean On;
//    private Holding holding;

    public expEffect(int scenario, int duration, int expEffect) {
        super(scenario, duration);
        setexpEffect(expEffect);
        while(isEffectOn())
        {
            holding.tile.occupy.player.gainExp(getexpEffect());
            System.out.format("%d", holding.tile.occupy.player.getHealth());
        }

    }

    public void setexpEffect(int expEffect) {
        this.expEffect = expEffect;
    }

    public int getexpEffect() {
        return expEffect;
    }
}
