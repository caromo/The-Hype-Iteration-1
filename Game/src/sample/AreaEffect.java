//Exists to hold information for the Area Effects that will happen in the tiles
//Members responsible: Callum, Daniel, Danilo

package sample;


public abstract class AreaEffect extends tileObject{
    private int scenarioNumber;
    private float duration;
    private boolean effectOn;


    //Sets the default values for the global variables
    public AreaEffect(int scenario, float duration){
        super(scenario);
        setEffectOn(false);
      this.duration = duration;
    }
    public abstract void setAmount(int x);//sets the amount of effect per second

    public abstract void fatality();

    public abstract void startEf();// starts effect

    //Allows for us to use durationin other classes while keeping it private
    public float getDuration(){
      return this.duration;
    }

    public void setEffectOn(boolean effectOn) {
        this.effectOn = effectOn;
    }

    @Override
    public int getEffect() {
        return (int) duration/10;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
}
