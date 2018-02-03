package sample;

public class Holding {
    public tile tile;
    public tileObject object;

    public Holding(tile tile, tileObject object) {
        this.tile = tile;
        this.object = object;
        tile.holding = this;
        object.holding = this;
    }

    public void remove() {
        tile.holding = null;
        object.holding = null;
    }
}
