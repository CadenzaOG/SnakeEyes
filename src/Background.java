import java.util.Arrays;

public class Background extends Panel {

    private final char[][] gameBoard = Utils.stringArraytoCharArray(Assets.gameBoard); // 12 7

    public Background(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.drawPanel(gameBoard);
    }




}
