package sample;

import java.util.Timer;
import java.util.TimerTask;

public class healingEffect extends AreaEffect{
    private int healingEffect;
    private int secondsPassed;

@Override
public void fatality() {}

public void startEf()
{
    secondsPassed = 0;
    Timer timer = new Timer();
    try {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (getDuration() < secondsPassed || (healingEffect.super.holding.getTile().occupy == null)) {
                    timer.cancel();
                }
                secondsPassed++;
                healing();


            }
        }, 0, (long) (1000));
    }
    catch(Exception e) {
        e.printStackTrace();
    }

}

    public void healing(){
        if(super.holding.getTile().occupy != null) {
            if (holding.getTile().occupy.getPlayer().getHealth() < 100) {
                holding.getTile().occupy.getPlayer().setHealth(holding.getTile().occupy.getPlayer().getHealth() + getHealingEffect());
            }
        }
    }
    public healingEffect(int scenario, int duration) {
        super(scenario, duration);
    }

    public int getHealingEffect() {
        return healingEffect;
    }

    public void setAmount(int healingEffect) {
        this.healingEffect = healingEffect;
    }
}
