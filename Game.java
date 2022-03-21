import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    private final Adventurer adventurer;
    private int level = 1;
    private Map<Integer, Animal> encounters = new HashMap<>();
    private final int[] mapSizes = {3, 5, 7, 10};
    private int mapLength = this.mapSizes[this.level];

    // Constructor
    public Game(String name) {
        this.adventurer = new Adventurer(name);
        setMap();
        gameplay();
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
        for (int i = 0; i < getMapLength(); i++) {
            if (r.nextBoolean()) {
                getEncounters().put(i, new Animal());
            }
        }
        System.out.println("Done");
    }
    public void nextLevel() {
        this.level++;
    }


    // Gameplay method
    public void gameplay() {
        for (int i = 0; i < getMapLength(); i++) {
            if (getEncounters().containsKey(i)) {
                System.out.println("You have met " + getEncounters().get(i).getName());
            }
        }
    }
}
