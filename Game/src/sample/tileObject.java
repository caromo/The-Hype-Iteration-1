package sample;

/*
Each implementation of tileObject will contain a unique scenario number
The numbers are: 0 = AreaEffect; 1 = Item; 2 = mapTransition;
 */
public abstract class tileObject {
    private int scenarioNumber;
    public Holding holding;
    public tileObject(int scenarioNumber) {
        this.scenarioNumber = scenarioNumber;
    }
    public int getScenario() {
        return scenarioNumber;
    }
    public abstract int getEffect();
}
