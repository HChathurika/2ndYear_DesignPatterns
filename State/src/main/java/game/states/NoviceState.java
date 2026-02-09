package game.states;

import game.character.CharacterState;
import game.character.GameCharacter;

public class NoviceState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " is training...");
        character.setExperience(character.getExperience() + 10);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novice cannot meditate yet!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novice cannot fight yet!");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 50) {
            System.out.println(character.getName() + " leveled up to Intermediate!");
            character.setState(new IntermediateState());
            character.setLevel(2);
        }
    }

    @Override
    public String getStateName() {
        return "Novice";
    }
}
