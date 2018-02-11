package sample;

import java.util.Timer;
import java.util.TimerTask;

public class AttackBoost extends OneShot{
    private int Attack;
    private int secondsPassed;
    private int duration;
    private boolean active; //DefenseBoost active
    public AttackBoost(int ItemID, int OneShotID, int Attack) {
        super(ItemID, OneShotID);
        this.Attack = Attack;
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
        this.Attack = y;
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
        return Attack;
    }
}