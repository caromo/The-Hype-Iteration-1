package sample;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.PrintWriter;
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
        tileSet[(int)startingPoint.getX()][(int)startingPoint.getY()].occupy = new Occupy(myPlayer, tileSet[(int)startingPoint.getX()][(int)startingPoint.getY()]);
    }

    //moves the player and resolves tile event (If passable)
    public void movePlayer(Point dir) {
        if ( tileSet[(int)dir.getX()][(int)dir.getY()].getPassable() ) {
            tileSet[(int) myPlayer.getPosition().getX()][(int)myPlayer.getPosition().getY()].occupy = null;
            tileSet[(int)dir.getX()][(int)dir.getY()].occupy = new Occupy(myPlayer, tileSet[(int)dir.getX()][(int)dir.getY()]);
            myPlayer.setPosition( (int)dir.getX(), (int)dir.getY() );
            updateMap(tileSet[(int)dir.getX()][(int)dir.getY()].applyEffect());
        }
    }

    //loads a new tileset and places the player in the starting point
    public void updateMap(int mapID) {
        if (mapID == -1) return;
        System.out.println("Destination MAP ID: " + mapID);

        loadMapFromID(mapID);
        moveToStart();
    }

    public void saveMap() {
        if(tileSet[0][0] == null){
            return;
        }
        int currID = mapID;
        int mapSizeX = tileSet.length;
        int mapSizeY = tileSet[0].length;

        try {
            //opens the map file based on MapID for writing
            PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/Save" + "/Map" + "/" + Integer.toString(mapID)
                    + ".txt");
            //write first line map size: X Y
            pw.println(mapSizeX + " " + mapSizeY);
            //write second line with startingPosition
            pw.println((int)myPlayer.getPosition().getX() + " " + (int)myPlayer.getPosition().getY());

            //Iterating through the map printing tiles in 5 digits
            for (int i = 0; i < mapSizeX; i++) {
                for (int j = 0; j < mapSizeY; j++) {
                    pw.print(tileSet[i][j].spill());
                    pw.print(" ");
                }
                pw.println();
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //given an ID, loads a map text file with tileset and starting point information
    public void loadMapFromID(int mapID) {
        try {
            saveMap();
            this.mapID = mapID;
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
                        tileSet[i][j] = new tile();
                        tileSet[i][j].fill('G', 4, Integer.parseInt(equid), Integer.parseInt(data), 0);
                    } else {
                        tileSet[i][j] = new tile();
                        tileSet[i][j].fill(temp.charAt(0), (int) temp.charAt(1)-48, (int) temp.charAt(2)-48, 0, temp.charAt(4)-'0');
                    }
                }
            }
            s_map.close();
            br_map.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void resetMap() {
        tileSet = new tile[10][10];
        mapID = 0;
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