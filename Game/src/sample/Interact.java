package sample;

public class Interact extends tileObject{
    private int requiredLevel;

    public Interact(int SN, int id) {
        super(SN);
        this.requiredLevel = id;
    }

    public int getRequired() {
        return requiredLevel;
    }

    @Override
    public int getEffect() {
        return requiredLevel;
    }
}
