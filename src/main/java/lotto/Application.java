package lotto;

import lotto.controller.GameSystem;

public class Application {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        gameSystem.runGame();
    }
}
