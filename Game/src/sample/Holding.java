//Members Responsible: Callum, Daniel, Danilo
//Exists to create an association between a Tile and a tileObject

package sample;

public class Holding {
    public tile tile;
    public tileObject object;

    //Creates the association, sets what tile is connected tom what tileObject
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
