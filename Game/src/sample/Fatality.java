package sample;

public class Fatality extends AreaEffect {
    private int byebye = 0;

    public Fatality(int scenario, float duration) {
        super(scenario, duration);
    }

    @Override
    public void startEf() {

    }
    @Override
    public void setAmount(int byebye) {

    }
    public void fatality()
    {
        System.out.println("jsdkf");
        if((super.holding.getTile().occupy.getPlayer() != null))
        {
            holding.getTile().occupy.getPlayer().setHealth(byebye);
            System.out.format("%d", holding.getTile().occupy.getPlayer().getHealth());
        }
    }
}
