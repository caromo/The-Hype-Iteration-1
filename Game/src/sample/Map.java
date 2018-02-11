package sample;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import static java.lang.Character.isLetter;

/*
Class Map
Responsibilities: 
    Keep track of player and tile location
    Transition into newer maps

Member(s) responsible: Carlo
*/
public class Map {
    private tile[][] tileSet;
    private Player myPlayer;
    private Point startingPoint;
    private int mapID;

    //generic map constructor: makes an empty 10x10 grid
    public Map(Player player) {
        myPlayer = player;
        tileSet = new tile[10][10];
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

    //moves the player and resolves tile event (If passable)
    public void movePlayer(Point dir) {
        if ( tileSet[(int)dir.getX()][(int)dir.getY()].getPassable() ) {
            tileSet[(int)myPlayer.getPosition().getX()][(int)myPlayer.getPosition().getY()].cancelEffect();
            tileSet[(int)myPlayer.getPosition().getX()][(int)myPlayer.getPosition().getY()].occupy = null;
            tileSet[(int)dir.getX()][(int)dir.getY()].occupy = new Occupy(myPlayer, tileSet[(int)dir.getX()][(int)dir.getY()]);
            myPlayer.setPosition( (int)dir.getX(), (int)dir.getY() );
            tileSet[(int)dir.getX()][(int)dir.getY()].applyEffect();
        }
    }

    //loads a new tileset and places the player in the starting point
    public void updateMap(int mapID) {
        loadMapFromID(mapID);
        moveToStart();
    }

    //given an ID, loads a map text file with tileset and starting point information
    public void loadMapFromID(int mapID) {

        try {
            File mapFile = new File(System.getProperty("user.dir") + "/Save/Map/" + mapID + ".txt");
            BufferedReader br_map = new BufferedReader(new FileReader(mapFile));
            Scanner s_map = new Scanner(br_map.readLine());
            String sMapSizeX = s_map.next();
            String sMapSizeY = s_map.next();
            int mapSizeX = Integer.parseInt(sMapSizeX);
            int mapSizeY = Integer.parseInt(sMapSizeY);

            s_map = new Scanner(br_map.readLine());
            Point newStart = new Point(Integer.parseInt(s_map.next()), Integer.parseInt(s_map.next()));
            startingPoint = newStart;

            tileSet = new tile[mapSizeX][mapSizeY];

            for (int i = 0; i < mapSizeX; i++) {
                String st = br_map.readLine();
                Scanner scanInput = new Scanner(st);

                for (int j = 0; j < mapSizeY; j++) {
                    String temp = scanInput.next();

                    if (!isLetter(temp.charAt(0))) {
                        String equid = "" + temp.charAt(0) + temp.charAt(1) + temp.charAt(2);
                        String data = "" + temp.charAt(3) + temp.charAt(4);
                        // System.out.println(equid + "" + data);      //testing
                        tileSet[i][j] = new tile();
                        tileSet[i][j].fill('g', 6, Integer.parseInt(equid), Integer.parseInt(data));
                    } else {
                        //System.out.println(temp.charAt(0)+ "" + temp.charAt(1) +"" + temp.charAt(2) + "" + temp.charAt(3) + "" +temp.charAt(4));    //testing
                        tileSet[i][j] = new tile();
                        tileSet[i][j].fill(temp.charAt(0), (int) temp.charAt(1)-48, (int) temp.charAt(2)-48, 0);
                    }
                }
            }
            s_map.close();
            br_map.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //accessors and/or mutators for Player, tileSet, and mapID
    public Player getPlayer() {
        return myPlayer;
    }
    public tile[][] getMap() {
        return tileSet;
    }
    public int getMapID() {
        return mapID;
    }
    public void setMapID(int newID) {
        mapID = newID;
    }
    public int getMapX() {
        return tileSet.length;
    }
    public int getMapY() {
        return tileSet[0].length;
    }
    public tile[][] getState() { return tileSet; }
}