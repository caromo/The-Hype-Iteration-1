package sample;

import java.awt.Point;
import java.io.BufferedReader;

public class Map {
    private Tile[][] tileSet;
    private Player myPlayer;
    private Point startingPoint;

    //generic map constructor: makes an empty 10x10 grid
    public Map() {
        myPlayer = new Player();
        tileSet = new Tile[10][10];
    }
    //map constructor: sets map to one specified by map ID and places player at the starting point
    public Map(int mapID, Player currPlayer) {
        loadMapFromID(mapID);
        myPlayer = currPlayer;
        moveToStart();
    }
    //function to place player at the beginning point of a specific map
    private void moveToStart() {
        myPlayer.setPosition((int)startingPoint.getX(), (int)startingPoint.getY());
    }

    public movePlayer(Point dir) {
        if ( tileSet[(int)dir.getX()][(int)dir.getY()].getPassable() ) {
            myPlayer.setPosition( (int)dir.getX(), (int)dir.getY() );
            tileSet[(int)dir.getX()][(int)dir.getY()].applyEffect();
        }
    }
    public void updateMap(int mapID) {
        loadMapFromID(mapID);
        moveToStart();
    } 
    public Player getPlayer() {
        return myPlayer;
    }
    public Tile[][] getMap() {
        return tileSet;
    }

    private void loadMapFromID(int mapID) {
        File mapFile = new File(System.getProperty("user.dir") + "/Save/Map/" + mapID +".txt");
        BufferedReader br_map = new BufferedReader(new FileReader(mapFile));
        Scanner s_map = new Scanner(br_map.readLine());
        String sMapSizeX = s_map.next();
        String sMapSizeY = s_map.next();
        int mapSizeX = Integer.parseInt(sMapSizeX);
        int mapSizeY = Integer.parseInt(sMapSizeY);

        s_map = new Scanner(br_map.readLine());
        Point newStart = new Point(Integer.parseInt(s_map.next()), Integer.parseInt(s_map.next()));
        startingPoint = newStart;

        tileSet = new Tile[mapSizeX][mapSizeY];

        for (int i = 0; i < mapSizeX; i++) {
            String st = br_map.readLine();
            Scanner scanInput = new Scanner(st);
        
            for (int j = 0; j < mapSizeY; j++) {
                String temp = scanInput.next();
        
                if (!isLetter(temp.charAt(0))){
                    String equid = "" + temp.charAt(0) + temp.charAt(1) + temp.charAt(2);
                    String data = "" + temp.charAt(3) + temp.charAt(4);
                    // System.out.println(equid + "" + data);      //testing
                    tileSet[i][j] = new tile();
                    tileSet[i][j].fill('g', 6, Integer.parseInt(equid), Integer.parseInt(data) );
                }
                else {
                    //System.out.println(temp.charAt(0)+ "" + temp.charAt(1) +"" + temp.charAt(2) + "" + temp.charAt(3) + "" +temp.charAt(4));    //testing
                    tileSet[i][j] = new tile();
                    tileSet[i][j].fill(temp.charAt(0), (int) temp.charAt(1), (int) temp.charAt(2), 0);
                }
            }
        }
        s_map.close();
        br_map.close();
    }
}