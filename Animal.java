import java.util.Random;

public class Animal {
    private final String name;
    private final int injuryPoints;
    private final int attackPoints;

    // Constructor
    public Animal() {
        Random r = new Random();

        String[] types = {"Wolf", "Bear", "Deer"};
        this.name = types[r.nextInt(3)];
        this.injuryPoints = r.nextInt(5)+1;
        this.attackPoints = r.nextInt(5)+1;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getInjuryPoints() {
        return injuryPoints;
    }
    public int getAttackPoints() {
        return attackPoints;
    }

    // Override Method
    @Override
    public String toString() {
        return getName() + ":\n\tInjury Points: " + getInjuryPoints() + "\n\tAttack Points: " + getAttackPoints();
    }
}
