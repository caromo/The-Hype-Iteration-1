package sample;

import java.util.Timer;
import java.util.TimerTask;

public class healingEffect extends AreaEffect{
    private int healingEffect;
    private int secondsPassed;
//    private Holding holding;
public void starteffects()
{
    secondsPassed = 0;
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            System.out.println("Seconds passes " + secondsPassed);
            healing();

        }
    }, 0 ,(long) (1000));

}

    public void startH()
    {
        starteffects();
    }
    public void healing(){
        if(holding.getTile().occupy.getPlayer().getHealth() < 100) {
            holding.getTile().occupy.getPlayer().setHealth(holding.getTile().occupy.getPlayer().getHealth() + getHealingEffect());
            System.out.format("%d", holding.getTile().occupy.getPlayer().getHealth());
        }
    }
    public healingEffect(int scenario, int duration, int healingEffect) {
        super(scenario, duration);
        setHealingEffect(healingEffect);


    }

    public int getHealingEffect() {
        return healingEffect;
    }

    public void setHealingEffect(int healingEffect) {
        this.healingEffect = healingEffect;
    }
}
