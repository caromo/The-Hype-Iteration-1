package sample;

public class Occupy {
    protected Player player;
    protected tile tile;

    public Occupy(Player player, tile tile) {
        this.player = player;
        player.occupy = this;
        this.tile = tile;
        tile.occupy = this;


    }
}
