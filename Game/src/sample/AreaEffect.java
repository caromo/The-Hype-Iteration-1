//Exists to hold information for the Area Effects that will happen in the tiles
//Members responsible: Callum, Daniel, Danilo

package sample;

import java.util.Timer;
import java.util.TimerTask;

public class AreaEffect extends tileObject{
    private int scenarioNumber;
    private float duration;
    private int secondsPassed;
    private boolean effectOn;


    //Sets the default values for the global variables
    public AreaEffect(int scenario, float duration){
        super(scenario);
        setEffectOn(false);
      this.duration = duration;

    }

    //Allows for us to use durationin other classes while keeping it private
    public float getDuration(){
      return this.duration;
    }

    public void starteffect()
    {
        secondsPassed = 0;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passes " + secondsPassed);
                setEffectOn(true);

            }
        };
        timer.schedule(task, (long) (getDuration()*1000));
        setEffectOn(false);
    }


    public int getScenarioNumber() {
        return scenarioNumber;
    }

    public void setScenarioNumber(int scenarioNumber) {
        this.scenarioNumber = scenarioNumber;
    }

    public void setEffectOn(boolean effectOn) {
        this.effectOn = effectOn;
    }
    public boolean isEffectOn() {
        return effectOn;
    }
}
