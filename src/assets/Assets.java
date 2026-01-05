package assets;

public class Assets {

    private static final char block = (char) 219; // █
    private static final char spot = (char) 8; // ◘

    public enum DieFaces {


        ONE(new char[][] {
                {block, block, block},
                {block, spot, block},
                {block, block, block}
        }),
        TWO(new char[][] {
                {block,block,spot},
                {block,block, block},
                {spot, block, block}
        }),
        THREE(new char[][]{
                {block,block,spot}, {block,spot, block}, {spot, block, block}
        }),
        FOUR(new char[][]{
                {spot, block, spot}, {block, block, block}, {spot, block, spot}
        }),
        FIVE(new char[][]{
                {spot, block, spot}, {block, spot, block}, {spot, block, spot}
        }),
        SIX(new char[][]{
                {spot, block, spot}, {spot, block, spot}, {spot, block, spot}
        });

        private final char[][] face;

        DieFaces(char[][] face) { this.face = face; }

        public char[][] getFace() {
            return face;
        }

        }


    public static final String[] snakeEyesLogo = new String[]{
            " __  __  __  ___  __ __  ____     ____ _  _  ____  __ ",
            "(( \\ ||\\ || // \\\\ || // ||       ||    \\\\// ||    (( \\",
            " \\\\  ||\\\\|| ||=|| ||<<  ||==     ||==   )/  ||==   \\\\ ",
            "\\_)) || \\|| || || || \\\\ ||___    ||___ //   ||___ \\_))",};

    public static final String[] leftDie = new String[] {
            "  ____  ",
            " /\\' .\\ ",
            "/: \\___\\",
            "\\' / . /",
            " \\/___/ " };

    public static final String[] rightDie = new String[] {
            "  _____  ",
            " / .  /\\ ",
            "/____/..\\",
            "\\'  '\\  /",
            " \\'__'\\/ ",};

    public static final String[] gameBoard = new String[] {
            "           ÚÄÄÄÄÄÄÄÄÄÄÄÂÄÄÄÄÄÄÄÄÄÄÄÄ¿            ",
            "  ____     ³           ³            ³     _____  ",
            " /\\' .\\    ³           ³            ³    / .  /\\ ",
            "/: \\___\\   ³           ³            ³   /____/..\\",
            "\\' / . /   ³           ³            ³   \\'  '\\  /",
            " \\/___/    ³           ³            ³    \\'__'\\/ ",
            "           ³           ³            ³            ",
            "           ³           ³            ³            ",
            "           ÀÄÄÄÄÄÄÄÄÄÄÄÁÄÄÄÄÄÄÄÄÄÄÄÄÙ            ",};



}

