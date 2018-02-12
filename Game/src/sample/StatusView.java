package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/*
Stats that need to be displayed: health, xp, xp to next level, attackpoints, defensepoints, level
 */

public class StatusView extends ListView{
    private Player player;

    public StatusView(Player player, Canvas canvas) {
        super(player, canvas);
        this.player = player;
    }

    public void render() {
        renderTextEntry("Name: " + player.getName(), 0);
        renderTextEntry("Level: " + Integer.toString(player.getLevel()), 1);
        renderTextEntry("XP to Next Level: " + Integer.toString(player.getExpToNextLvl()), 2);
        renderTextEntry("Health: " + Integer.toString(player.getHealth()), 3);
        renderTextEntry("Attack: " + Integer.toString(player.getAttackPoints()), 4);
        renderTextEntry("Defense: " + Integer.toString(player.getDefensePoints()), 5);
    }

    public String toString() {
        return "Status View";
    }
}
