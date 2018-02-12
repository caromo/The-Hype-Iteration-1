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

    public void startEf() // starts timer
    {
        secondsPassed = 0;
        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (getDuration() < secondsPassed || (expEffect.super.holding.getTile().occupy == null)) {
                        timer.cancel();
                    }
                    secondsPassed++;
                    expEf();
                }
            }, 0, (long) (1000));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public expEffect(int scenario, int duration) {
        super(scenario, duration);
    }

    public void expEf(){ //applies effect
        if(super.holding.getTile().occupy != null) {
            super.holding.getTile().occupy.getPlayer().gainExp(getexpEffect());
        }
    }

    public void setAmount(int expEffect) {
        this.expEffect = expEffect;
    }

    public int getexpEffect() {
        return expEffect;
    }
}
