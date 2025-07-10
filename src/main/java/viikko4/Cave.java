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
        if (monsters == null || monsters.isEmpty()) {
            System.out.println("Luola on tyhjä.");
            return;
        }
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println("Luonlan hirviöt:");
            Monster monster = monsters.get(i);
            monster.printInfo(i + 1);
        }
    }
    public Monster getMonster(int index) {
        if (index >= 0 && index < monsters.size()) {
            return monsters.get(index);
        }
        return null; // Return null if index is out of bounds
    }
}
