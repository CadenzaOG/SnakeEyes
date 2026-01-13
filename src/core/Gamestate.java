package core;

public enum Gamestate {
    WAITING_FOR_ROLL("Press [ENTER] to Roll"),
    WAITING_FOR_DECISION("[ENTER] to Roll again, [SPACE] to Pass"),
    ROLLED_ONE("Rolled one, this turns points Lost"),
    SNAKE_EYES("Snake Eyes, all points lost!"),
    GAME_OVER("Game Over!");

    private final String message;

    Gamestate(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
