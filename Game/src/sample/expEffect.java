package sample;

import java.util.Timer;
import java.util.TimerTask;

public class expEffect extends AreaEffect{
    private int expEffect;
    private boolean On;
    private int secondsPassed;

    public void startEf() // starts timer
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passes " + secondsPassed);
                if(getDuration() < secondsPassed || !expEffect.super.isEffectOn())
                {
                    timer.cancel();
                }
                expEf();



            }
        }, 0 ,(long) (1000));

    }
    public expEffect(int scenario, int duration) {
        super(scenario, duration);
    }

    public void expEf(){ //applies effect
        if(super.holding.getTile().occupy.getPlayer() != null) {
            super.holding.getTile().occupy.getPlayer().gainExp(getexpEffect());

        System.out.format("%d", holding.getTile().occupy.getPlayer().getExpToNextLvl());
        }
    }

    public void setAmount(int expEffect) {
        this.expEffect = expEffect;
    }

    public int getexpEffect() {
        return expEffect;
    }
}
