package panels;

import assets.Assets;
import utils.Utils;

public class Logo extends Panel {

    private final char[][] logo = Utils.addBorders(Assets.snakeEyesLogo); // 1 2

    public Logo(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.drawPanel(logo);
    }
}
