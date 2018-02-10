package sample;

import java.awt.Point;

public class Map {
    private int mapID;
    private tile[][] tileSet;
    private Player myPlayer;
    private Point startingPoint;

    //generic map constructor: makes an empty 20x20 grid
    public Map() {
        tileSet = new tile[20][20];
        startingPoint = new Point(10,10);
        for(int i = 0; i < tileSet.length; i++) {
            for(int j = 0; j < tileSet.length; j++) {
                tileSet[i][j] = new tile(new Terrain(0)); //blank tiles
            }
        }
        tileSet[1][1] = new tile(new Item(4, 1));
        tileSet[4][2] = new tile(new Terrain(1));
        tileSet[4][3] = new tile(new Terrain(1));
        tileSet[5][2] = new tile(new Terrain(1));
        tileSet[5][3] = new tile(new Terrain(1));

        tileSet[7][7] = new tile(new Terrain(2));
        tileSet[7][6] = new tile(new Terrain(2));
        tileSet[6][7] = new tile(new Terrain(2));
    }
    //map constructor: sets map to one specified by map ID and places player at the starting point
    public Map(int mapID, Player currPlayer, tile[][] map, Point start) {
        tileSet = map;
        startingPoint = start;
        myPlayer = currPlayer;
        moveToStart();
    }
    //function to place player at the beginning point of a specific map
    private void moveToStart() {
        myPlayer.setPosition((int)startingPoint.getX(), (int)startingPoint.getY());
    }

    public void movePlayer(Point dir) {
        if (tileSet[dir.x][dir.y].getPassable()) {
            myPlayer.setPosition(dir.x, dir.y);
            tileSet[dir.x][dir.y].applyEffect();
        }
    }
    private void updateMap(int NewmapID, tile[][] neoSet, Point neoStart) {
        startingPoint = neoStart;
        tileSet = neoSet;
        moveToStart();
    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public Player getPlayer() {
        return myPlayer;
    }
    public tile[][] getState() { return tileSet; }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getMapX() {
        return tileSet.length;
    }

    public int getMapY() {
        return tileSet[0].length;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }
}
