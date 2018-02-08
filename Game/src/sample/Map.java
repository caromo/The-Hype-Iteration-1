package sample;

public class Map {
    private Tile[][] tileSet;
    private Player myPlayer;
    private Point startingPoint;

    //generic map constructor: makes an empty 10x10 grid
    public Map() {
        tileSet = new Tile[10][10];
    }
    //map constructor: sets map to one specified by map ID and places player at the starting point
    public Map(int mapID, player currPlayer) {
        tileSet = idToMap(mapID);
        startingPoint = idToStart(mapID);
        myPlayer = currPlayer;
        moveToStart();
    }
    //function to place player at the beginning point of a specific map
    private void moveToStart() {
        myPlayer.setPosition(startingPoint.getX(), startingPoint.getY());
    }

    public movePlayer(Direction dir) {
        if (tileSet[dir.x][dir.y].getPassable()) {
            myPlayer.setPosition(dir.x, dir.y);
            tileSet[dir.x][dir.y].applyEffect();
        }
    }
    private void updateMap(int mapID) {
        startingPoint = idToStart(mapID);
        tileSet = idToMap(mapID);
        moveToStart();
    } 
    public Player getPlayer() {
        return myPlayer;
    }
    public Tile[][] getMap() {
        return tileSet;
    }
}
