package sample;

public abstract class tileObject {
    private int scenarioNumber;
    public Holding holding;
    protected AreaEffect areaEffect;

    public tileObject(int scenarioNumber) {
        this.scenarioNumber = scenarioNumber;
    }
    public int getScenario() {
        return scenarioNumber;
    }

    public void setAreaEffect(AreaEffect areaEffect) {
        this.areaEffect = areaEffect;
    }

    public AreaEffect getAreaEffect() {
        return areaEffect;
    }
}
