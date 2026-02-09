package game.character;

import game.states.*;

public class GameCharacter {
    private String name;
    private int level;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // Initial state
    }

    // Getters and Setters
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public String getName() { return name; }

    // State operations
    public void setState(CharacterState state) {
        this.state = state;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void printStatus() {
        System.out.println("\n=== Character Status ===");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level + " (" + state.getStateName() + ")");
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);
    }
}
