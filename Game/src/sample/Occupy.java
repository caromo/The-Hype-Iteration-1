package sample;

public class Occupy {
    private Player player;
    private tile Tile;

    public Occupy(Player player, tile tile) {
        this.player = player;
        player.occupy = this;
        Tile = tile;
        tile.occupy = this;
    }

    //Disassociates Player with tile.
    public void vacate() {
        player = null;
    }

    public Player getPlayer() { return player; }

    public tile getTile() { return Tile; }

    public void setPlayer(Player p) {
        player = p;
    }

    public void setTile(tile t) {
        Tile = t;
    }
}
