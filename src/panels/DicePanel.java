package panels;

import assets.Assets;
import core.Dice;
import utils.Cell;

import java.util.Random;

public class DicePanel extends Panel {

    private Random random;

    public DicePanel() {
        super(19, 13, 6, 11);
        this.random = new Random();
    }

    public void updateDice(Dice dice) {
        this.clearPanel();
        int[] d = dice.getDice();
        int offset = 6;
        for (int i = 0; i < d.length; i++) {
            int x = random.nextInt(3);
            int y = random.nextInt(3) + 1;
            System.out.println("y = " + y);
            if (i == 1) {
                x += offset;
            }
            drawPanel(Assets.DieFaces.values()[d[i] - 1].getFace(), x, y);
        }
    }





}
