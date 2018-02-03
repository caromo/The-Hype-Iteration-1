package sample;


public class tile {
    public Occupy occupy;
    public Holding holding;

    public tile(tileObject objType) {
        holding = new Holding(this, objType);
    }


    //Performs the action associated with the tileObject
    public void applyEffect() {
        if(holding == null) {//Empty tile

        }
        int scenario = holding.object.getScenario();
        if(scenario == 0)  {//Area effect

        } else if(scenario == 1) {//Item
            ((Item) holding.object).giveItem();
        }
    }
}
