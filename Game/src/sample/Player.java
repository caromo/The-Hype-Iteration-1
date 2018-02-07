package sample;

import java.lang.Math;
import java.awt.Point;

public class Player extends GameObject {
    private int Health;
    private int AttackPoints;
    private int DefensePoints;
    private int Experience;
    private int ExpToNextLvl;
    private int Level;
    private String name;
    private Inventory bag;
    private Point pos;
    public Occupy occupy;
    public Player(String name, int x, int y){
        this.name = name;
        Level = 1;
        ExpToNextLvl = 100;
        Experience = 0;
        Health = 100;
        AttackPoints = 5;
        DefensePoints = 5;
        bag = new Inventory();
        pos = new Point(x,y);
    }
    public Player(){
        this.name = "H Y P E";
        Level = 1;
        ExpToNextLvl = 100;
        Experience = 0;
        Health = 100;
        AttackPoints = 5;
        DefensePoints = 5;
        bag = new Inventory();
        pos = new Point(0,0);
    }

    public int getHealth() {
        return Health;
    }

    public int getExperience(){
        return Experience;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    // May be unnecessary
    public void setExperience(int experience) {
        this.Experience = experience;
    }

    public void gainExp(int exp) {
        if (exp >= ExpToNextLvl)
        {
            LevelUp();
            exp -= ExpToNextLvl;
            ExpToNextLvl = Level * 100;
            gainExp(exp);
        }
        else {
            ExpToNextLvl -= exp;
            Experience = exp;
        }
    }

    private void LevelUp()
    {
        Level++;
        Health = (int)Math.log10((double)(Level*100)) + (int)1.247*(Level * 100);
        AttackPoints = (int)(Math.log10((double)(Level))*5)+AttackPoints;
        DefensePoints = (int)(Math.log10((double)(Level))*2.5)+DefensePoints;
        // Increase other stats here as needed.
    }

    public Inventory getInventory(){
        return bag;
    }
    public Point getPosition()
    {
        return pos;
    }

    public void setPosition(int x, int y) //for testing purposing only
    {
        pos.setLocation(x,y);
    }

    public int getExpToNextLvl() {
        return ExpToNextLvl;
    }

    public void setExpToNextLvl(int expToNextLvl) {
        ExpToNextLvl = expToNextLvl;
    }

    public int getAttackPoints() {
        return AttackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        AttackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return DefensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        DefensePoints = defensePoints;
    }

    public String getName() {
        return name;
    }

}
