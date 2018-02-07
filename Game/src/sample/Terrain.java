package sample;

public class Terrain extends tileObject {
    private int terrainType;
    public Terrain(int type) {
        super(0);
        terrainType = type;
    }

    public int getTerrainType() {
        return terrainType;
    }
}
