package game.states;

import game.character.CharacterState;
import game.character.GameCharacter;

public class ExpertState implements CharacterState {

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
        System.out.println(character.getName() + " is fighting...");
        character.setHealth(character.getHealth() - 10);
        character.setExperience(character.getExperience() + 20);
        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 200) {
            System.out.println(character.getName() + " reached Master Level!");
            character.setState(new MasterState());
            character.setLevel(4);
        }
    }

    @Override
    public String getStateName() {
        return "Expert";
    }
}
