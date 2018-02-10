package sample;

import java.util.Timer;
import java.util.TimerTask;

public class expEffect extends AreaEffect{
    private int expEffect;
    private boolean On;
    private int secondsPassed;
//    private Holding holding;

    public void startexp()
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passes " + secondsPassed);
                expEf();


            }
        }, 0 ,(long) (1000));

    }
    public expEffect(int scenario, int duration, int expEffect) {
        super(scenario, duration);
        setexpEffect(expEffect);
        startexp();

    }
    public void expEf(){
        super.holding.tile.occupy.player.gainExp(getexpEffect());
        System.out.format("%d", holding.tile.occupy.player.getExpToNextLvl());
    }

    public void setexpEffect(int expEffect) {
        this.expEffect = expEffect;
    }

    public int getexpEffect() {
        return expEffect;
    }
}
