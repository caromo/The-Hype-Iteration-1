package sample;

import java.util.Timer;
import java.util.TimerTask;

public class damageEffect extends AreaEffect{
    private int damage;
    private boolean damOn;
    private int secondsPassed;

    public damageEffect(int scenario, int duration, int damage) {
        super(scenario, duration);
    }

    public void startEf()
    {
        setOn(true);
        startEffect();
        Ef();
    }

    public void startEffect()
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.print("Seconds passes " + secondsPassed + "\t\t");
                Ef();
            }
        }, 0 ,(long) (1000));
    }

    public void Ef()
    {
        super.holding.getTile().occupy.getPlayer().takeDamage(getDamageEffect());
        System.out.format("%d", holding.getTile().occupy.getPlayer().getHealth(),"\t");
    }

    public void setDamageEffect(int damageEffect) {
        this.damage = damageEffect;
    }

    public int getDamageEffect() {
        return damage;
    }

    public void setOn(boolean on) {
        damOn = on;
    }

    public boolean isOn() {
        return damOn;
    }
}
