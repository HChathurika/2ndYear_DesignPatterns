package game.states;

import game.character.CharacterState;
import game.character.GameCharacter;

public class IntermediateState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " is training...");
        character.setExperience(character.getExperience() + 10);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " is meditating...");
        character.setHealth(character.getHealth() + 10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediate cannot fight yet!");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 100) {
            System.out.println(character.getName() + " leveled up to Expert!");
            character.setState(new ExpertState());
            character.setLevel(3);
        }
    }

    @Override
    public String getStateName() {
        return "Intermediate";
    }
}
