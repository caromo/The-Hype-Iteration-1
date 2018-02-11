package sample;

import java.util.Timer;
import java.util.TimerTask;

public class damageEffect extends AreaEffect{
    private int damage;
    private int secondsPassed;

    @Override
    public void fatality() {

    }

    public damageEffect(int scenario, int duration) {
        super(scenario, duration);
    }

    public void startEf() // starts timer
    {
        secondsPassed = 0;
        Timer timer = new Timer();
            try {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {


                            if ((getDuration() < secondsPassed) || (damageEffect.super.holding.getTile().occupy == null)) {
                                timer.cancel();
                            }
                            secondsPassed++;
                            System.out.print("Seconds passes " + secondsPassed + "\t\t");
                            Ef();
                        }
                    }, 0, (long) (1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void Ef()//applies effect
    {
        if(super.holding.getTile().occupy != null) {
            super.holding.getTile().occupy.getPlayer().takeDamage(getDamageEffect());
            System.out.format("%d", holding.getTile().occupy.getPlayer().getHealth(), "\t");
        }
    }

    public void setAmount(int damageEffect) {
        this.damage = damageEffect;
    }

    public int getDamageEffect() {
        return damage;
    }

}
