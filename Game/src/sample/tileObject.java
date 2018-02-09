package sample;

<<<<<<< HEAD
/*
Each implementation of tileObject will contain a unique scenario number
The numbers are: 0 = AreaEffect; 1 = Item; 2 = mapTransition;
 */
public abstract class tileObject {
    private int scenarioNumber;
    public Holding holding;
=======
public abstract class tileObject {
    private int scenarioNumber;
    public Holding holding;
    protected AreaEffect areaEffect;

>>>>>>> TileObject
    public tileObject(int scenarioNumber) {
        this.scenarioNumber = scenarioNumber;
    }
    public int getScenario() {
        return scenarioNumber;
    }
<<<<<<< HEAD
    public abstract int getEffect();
=======

    public void setAreaEffect(AreaEffect areaEffect) {
        this.areaEffect = areaEffect;
    }

    public AreaEffect getAreaEffect() {
        return areaEffect;
    }
>>>>>>> TileObject
}
