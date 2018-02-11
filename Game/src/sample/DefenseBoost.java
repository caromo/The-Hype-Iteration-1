package sample;

import java.util.Timer;
import java.util.TimerTask;

public class DefenseBoost extends OneShot{
    private int Defense;
    private int secondsPassed;
    private int duration;
    private boolean active; //DefenseBoost active
    public DefenseBoost(int ItemID, int OneShotID, int def) {
        super(ItemID, OneShotID);
        this.Defense = def;
    }
    public boolean active(){
        return active;
    }
    public void startEf()
    {
        active = true;
        secondsPassed = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passes " + secondsPassed);
                if(getDuration() < secondsPassed)
                {
                    active = false;
                    timer.cancel();
                }

            }
        }, 0 ,(long) (1000));

    }

    public void setAmount(int y)
    {
        this.Defense = y;
    }
    public void setDur(int x)//sets how long the effect lasts
    {
        this.duration = x;
    }
    public int getDuration()
    {
        return duration;
    }

    public int supplyBenefit() {
        return Defense;
    }
}