//Members Responsible: Callum, Daniel, Danilo
//Exists to hold the required information so that a Map Transition can occur

package sample;

public class MapTransition extends tileObject{
    private int destination;
    MapTransition(int SN, int dest) {
        super(SN);
        destination = dest;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public int getEffect() {
        return destination;
    }
}
