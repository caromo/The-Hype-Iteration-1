package sample;

import java.util.Timer;
import java.util.TimerTask;

public class damageEffect extends AreaEffect{
    private int damageEffect;
    private boolean damOn;
    private int secondsPassed;
//    private Holding holding;

    public damageEffect(int scenario, int duration, int damageEffect) {
        super(scenario, duration);
//        setDamageEffect(damageEffect);
//        Ef();




    }

    public void startEf()
    {
        setOn(true);
        starteffects();
        Ef();



    }
    public void starteffects()
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passes " + secondsPassed);
                Ef();


            }
        }, 0 ,(long) (1000));

    }

    public void Ef()
    {
        int space = 0;
//        for(int i = 0; i < super.getDuration(); i++)
//        {
//            super.starteffect();
//            while(!super.isEffectOn())
//            {
//
//            }
            super.holding.tile.occupy.player.takeDamage(getDamageEffect());
            System.out.format("%d", holding.tile.occupy.player.getHealth());
//            System.out.println(i);

//        }

//        do{
//            if(space > 10) {
//                super.holding.tile.occupy.player.takeDamage(getDamageEffect());
//                System.out.format("%d", holding.tile.occupy.player.getHealth());
//                space = 0;
//            }
//
//        }while(super.isEffectOn());
    }

    public void setDamageEffect(int damageEffect) {
        this.damageEffect = damageEffect;
    }

    public int getDamageEffect() {
        return damageEffect;
    }

    public void setOn(boolean on) {
        damOn = on;
    }

    public boolean isOn() {
        return damOn;
    }
}
