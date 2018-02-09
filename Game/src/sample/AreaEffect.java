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
    protected damageEffect damageEffects;


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
