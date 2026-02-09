package game.states;

import game.character.CharacterState;
import game.character.GameCharacter;

public class MasterState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " is already a Master! Game over.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " is already a Master! Game over.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + " is already a Master! Game over.");
    }

    @Override
    public String getStateName() {
        return "Master";
    }
}
