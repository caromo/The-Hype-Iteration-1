package sample;

public abstract class tileObject {
    private int scenarioNumber;
    public Holding holding;
    public tileObject(int scenarioNumber) {
        this.scenarioNumber = scenarioNumber;
    }
    public int getScenario() {
        return scenarioNumber;
    }
}
