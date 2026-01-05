package core;

public enum Turn {
    PLAYER_ONE("core.Player one"), PLAYER_TWO("core.Player two");

    private final String displayName;

    Turn(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
