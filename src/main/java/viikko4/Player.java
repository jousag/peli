package viikko4;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int attack(Monster monster) {
        if (monster.getHealth() > 0) {
            System.out.println(name + " hyökkää " + monster.getType() + " hirviöön!");
            return monster.takeDamage(10);
        } else {
            System.out.println(monster.getType() + " hirviö on jo kuollut!");
            return -1;
        }
    }

}
