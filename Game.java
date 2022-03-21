import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private final Adventurer adventurer;
    private int level = 0;
    private Map<Integer, Animal> encounters = new HashMap<>();
    private final int[] mapSizes = {3, 5, 7, 10};
    private int mapLength = this.mapSizes[this.level];

    // Constructor
    public Game() {
        System.out.print("Enter your adventurer's name: ");
        this.adventurer = new Adventurer(inputString());
        nextLevel();
        while (this.adventurer.isAlive() && this.level<5) {
            System.out.println("Starting...");
            wait(1);
            gameplay();
            System.out.println("Loading next level...");
            wait(2);
            nextLevel();
        }
    }

    // Getters
    public Adventurer getAdventurer() {
        return adventurer;
    }
    public int getLevel() {
        return level;
    }
    public Map<Integer, Animal> getEncounters() {
        return encounters;
    }
    public int[] getMapSizes() {
        return mapSizes;
    }
    public int getMapLength() {
        return this.mapLength;
    }

    // Setters
    public void setMap() {
        Random r = new Random();
        this.encounters.put(0, new Animal());
        for (int i = 0; i < getMapLength()+1; i++) {
            if (r.nextBoolean()) {
                this.encounters.put(i, new Animal());
            }
        }
    }
    public void nextLevel() {
        this.level++;
        if (getLevel() > 4) {
            System.out.println("Game over, you won! Here's how you ended the game:\n" + getAdventurer().toString());
            System.exit(0);
        } else {
            getEncounters().clear();
            mapLength = getMapSizes()[getLevel() - 1];
            setMap();
        }
    }

    // Helper Methods
    private int rollDice() {
        Random r = new Random();
        return r.nextInt(6) + r.nextInt(6);
    }
    private String inputString() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    private void wait(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException ignored) {}
    }

    // Gameplay methods
    private void heal(int animal) {
        int rolled = rollDice();
        wait(1);
        if (rolled > getEncounters().get(animal).getInjuryPoints()) {
            System.out.println("You rolled a " + rolled + ". The animal is healed!\n" +
                    "Your healing points go up by 2");
            getAdventurer().setHealingPoints(getAdventurer().getHealingPoints() + 2);
        } else {
            System.out.println("You rolled a " + rolled + ". The animal could not be healed\n" +
                    "Your healing points go down by 1");
            getAdventurer().setHealingPoints(getAdventurer().getHealingPoints() - 1);
        }
        wait(1);
    }

    public void gameplay() {
        System.out.println("Level " + getLevel() + ", Map Length: " + getMapLength());
        wait(1);
        for (int i = 0; i < getMapLength(); i++) {
            System.out.println("Stage " + (i+1) + "\n" + getAdventurer().toString());
            if (getEncounters().containsKey(i)) {
                System.out.println("You have met " + getEncounters().get(i).toString());

                System.out.println("Would you like to heal the animal? [Y/N]");
                String choice = inputString();
                if (choice.equals("Y")) {
                    heal(i);
                } else {
                    System.out.println("Your healing points stay the same");
                }

            } else {
                System.out.println("There were no animals to heal, you move freely");
            }
            wait(1);
        }
        System.out.println("End of level " + getLevel());
    }
}
