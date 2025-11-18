public enum Turn {
    PLAYER_ONE("Player one"), PLAYER_TWO("Player two");

    private final String displayName;

    Turn(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
