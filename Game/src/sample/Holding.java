//Members Responsible: Callum, Daniel, Danilo
//Exists to create an association between a Tile and a tileObject

package sample;

public class Holding extends tileObject{
    protected tile tile;
    protected tileObject object;

    public Holding(tile tile, tileObject object) {
        this.tile = tile;
        this.object = object;
        tile.holding = this;
        object.holding = this;
    }

    //Removes the association
    public void remove() {
        tile.holding = null;
        object.holding = null;
    }
}
