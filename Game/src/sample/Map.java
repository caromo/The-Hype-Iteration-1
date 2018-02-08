package sample;

public class Map {
    tile[][] tileSet = new tile[20][20];
    public Map() {
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

    public tile[][] getMap() {
        return tileSet;
    }
}
