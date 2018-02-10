//Members Responsible: Callum, Daniel, Danilo
//Exists to create an association between a Tile and a tileObject

package sample;

public class Holding {
    private tile Tile;
    private tileObject object;

    public Holding(tile tile, tileObject obj) {
        Tile = tile;
        object = obj;
        tile.holding = this;
        obj.holding = this;
    }

    public tileObject getObject() { return object; }

    public void setObject(tileObject t) {
        object = t;
    }

    public tile getTile() { return Tile; }

    public void setTile(tile t) {
        Tile = t;
    }

    public void remove() {
        object.holding = null;
    }
}
