package sample;

import java.util.Timer;
import java.util.TimerTask;

public class expEffect extends AreaEffect{
    private int expEffect;
    private boolean On;
    private int secondsPassed;
    @Override
    public void fatality() {
    }

    public void startEf() {
        super.holding.getTile().occupy.getPlayer().gainExp(expEffect);
    }

    public expEffect(int scenario, int duration) {
        super(scenario, duration*10);
    }

    public void setAmount(int expEffect) {
        this.expEffect = expEffect;
    }

    public int getexpEffect() {
        return expEffect/10;
    }
}
