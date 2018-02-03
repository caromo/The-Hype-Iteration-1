package sample;

public class Occupy {
    Player player;
    tile tile;

    public Occupy(Player player, tile tile) {
        this.player = player;
        this.tile = tile;
        tile.occupy = this;
        player.occupy = this;
    }
}
