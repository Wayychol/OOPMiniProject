import java.util.Random;

public class Plant {
    private final String name;
    private final int healingPoints;
    private final boolean poisonous;

    public Plant() {
        Random r = new Random();

        String[] types = {"Berry", "Mint Leaf", "Daffodil", "Mushroom"};
        this.name = types[r.nextInt(4)];
        this.healingPoints = r.nextInt(4)+1;
        this.poisonous = r.nextInt(4) == 2;
    }

    public String getName() {
        return this.name;
    }
    public int getHealingPoints() {
        return this.healingPoints;
    }
    public boolean isPoisonous() {
        return this.poisonous;
    }

    // Override Methods
    @Override
    public String toString() {
        return getName() + " with " + getHealingPoints() + " healing points";
    }
}
