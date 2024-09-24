package ivwg.tennis.types;

import java.util.Random;

public enum Action {
    WIN_PLAYER_1, WIN_PLAYER_2, FAULT;

    public static Action generateRandomAction() {
        Random random = new Random();
        int actionIndex = random.nextInt(Action.values().length);
        return Action.values()[actionIndex];
    }
}