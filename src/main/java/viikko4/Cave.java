package viikko4;

import java.util.ArrayList;
import java.io.Serializable;

public class Cave implements Serializable {
    private ArrayList<Monster> monsters;
    private Player player;

    public Cave(Player player) {
        this.player = player;
    }

    public void addMonster(Monster monster) {
        if (monsters == null) {
            monsters = new ArrayList<>();
        }
        monsters.add(monster);
    }

    public void listMonsters() {
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            monster.printInfo(i + 1);
        }
    }
    public Monster getMonster(int index) {
        if (monsters != null && index >= 0 && index < monsters.size()) {
            return monsters.get(index);
        }
        System.out.println("Hirviötä ei löytynyt.");
        return null;
    }
    public Player getPlayer() {
        return player;
    }
    public void removeMonster(Monster monster) {
        if (monsters != null) {
            monsters.remove(monster);
        }
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

}