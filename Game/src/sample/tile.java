package sample;


public class tile {
    public Occupy occupy;
    public Holding holding;

    public tile(tileObject objType) {
        holding = new Holding(this, objType);
    }


    //Performs the action associated with the tileObject
    public void applyEffect() {
        if(holding == null) {

        }
        int scenario = holding.object.getScenario();
        if(scenario == 1)  {//Area effect

        } else if(scenario == 4) {//Item
            ((Item) holding.object).giveItem();
        }
    }
    public int getScenario() {
        if(holding == null) {
            return -1;
        }
        return holding.object.getScenario();
    }
}
