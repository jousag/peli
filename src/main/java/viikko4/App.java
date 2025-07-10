package viikko4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Syötä pelaajan nimi:");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);
        Cave cave = new Cave(player);
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    System.out.println("Anna hirviön tyyppi:");
                    String monsterType = sc.nextLine();
                    System.out.println("Anna hirviön elämän määrä numerona: ");
                    int health = sc.nextInt();
                    sc.nextLine(); // Clear the newline character
                    Monster monster = new Monster(monsterType, health);
                    cave.addMonster(monster);
                    break;
                case 2:
                    cave.listMonsters();
                    break;
                case 3:
                    System.out.println("Valitse hirviö, johon hyökätä: ");
                    cave.listMonsters();
                    int monsterIndex = sc.nextInt() - 1; // Convert to zero-based index
                    Monster selectedMonster = cave.getMonster(monsterIndex);
                    if (selectedMonster != null) {
                        int result = player.attack(selectedMonster);
                        if (result == 0) {
                            cave.removeMonster(selectedMonster);
                        }
                    } else {
                        System.out.println("Virheellinen hirviövalinta.");
                    }
                    break;
                case 4:
                    System.out.println("Anna tiedostonnimi, johon peli tallennetaa:");
                    String saveFileName = sc.nextLine();
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFileName));
                        out.writeObject(cave);
                        out.close();
                        System.out.println("Peli tallennettiin tiedostoon: " + saveFileName);
                    } catch (IOException e) {
                        System.err.println("Virhe pelin tallentamisessa: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                    String loadFileName = sc.nextLine();
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFileName));
                        Cave loadedCave = (Cave) in.readObject();
                        in.close();
                        cave = loadedCave;
                        System.out.println("Peli ladattu tiedostosta: " + loadFileName + ". Tervetuloa takaisin, " + player.getName());
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Virhe pelin lataamisessa: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                    sc.close();
                    exit = true;
                    break;
                default:
                    System.out.println("Tuntematon valinta, yritä uudelleen.");
            }

        }

    }
}
