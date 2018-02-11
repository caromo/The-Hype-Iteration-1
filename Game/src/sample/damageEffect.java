package sample;

import java.util.Timer;
import java.util.TimerTask;

public class damageEffect extends AreaEffect{
    private int damage;
    private int secondsPassed;

    public damageEffect(int scenario, int duration) {
        super(scenario, duration);
    }

    public void startEf() // starts timer
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.print("Seconds passes " + secondsPassed + "\t\t");
                Ef();
                if((getDuration() < secondsPassed) || !damageEffect.super.isEffectOn())
                {
                    timer.cancel();
                }
            }
        }, 0 ,(long) (1000));
    }

    public void Ef()//applies effect
    {
        super.holding.getTile().occupy.getPlayer().takeDamage(getDamageEffect());
        System.out.format("%d", holding.getTile().occupy.getPlayer().getHealth(),"\t");
    }

    public void setAmount(int damageEffect) {
        this.damage = damageEffect;
    }

    public int getDamageEffect() {
        return damage;
    }

}
