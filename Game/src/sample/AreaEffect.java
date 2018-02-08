package sample;

public class AreaEffect extends tileObject{
    private float duration;
    public AreaEffect(int SN, float dur) {
        super(SN);
        duration = 10*dur;
    }

    @Override
    public int getEffect() {
        return (int) duration/10;
    }
}
