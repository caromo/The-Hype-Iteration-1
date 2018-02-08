package sample;

public class MapTransition extends tileObject{
    private int destination;
    MapTransition(int SN, int dest) {
        super(SN);
        destination = dest;
    }

    public int getDestination() {
    	return this.destination;
    }
}
