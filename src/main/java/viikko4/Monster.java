package viikko4;
import java.io.Serializable;

public class Monster implements Serializable {
    private String type;
    private int health;

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void printInfo(int number) {
        System.out.println(number + ": " + this.type + " / " + this.health);
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int takeDamage(int dmg) {
        this.health -= dmg;
        if (this.health > 0) {
            System.out.println("Hirviöllä on " + this.health + " elämää jäljellä.");
            return this.health;
        } else {
            System.out.println("Hirviö on kuollut.");
            return 0;
        }
    }

}