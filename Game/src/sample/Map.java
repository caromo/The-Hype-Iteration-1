package sample;

public class Map {
    tile[][] tileSet = new tile[20][20];
    public Map() {
        for(int i = 0; i < tileSet.length; i++) {
            for(int j = 0; j < tileSet.length; j++) {
                tileSet[i][j] = new tile(new EmptyTile()); //blank tiles
            }
        }
        tileSet[1][1] = new tile(new Item(0));
    }

    public tile[][] getMap() {
        return tileSet;
    }
}
