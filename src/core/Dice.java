package core;

import java.util.Arrays;
import java.util.Random;


public class Dice {

    private int[] dice;
    private Random roll;

    public Dice() {
        roll = new Random();
        dice = new int[]{0, 0};
        rollDice();
    }

    public void rollDice() {
        int i = 0;
        for (int d : dice) {
            d = roll.nextInt(6) + 1;
            dice[i] = d;
            i++;
        }
    }

    public int[] getDice() {
        return dice;
    }

    public int getTotal() {
        return Arrays.stream(dice).sum();
    }

}





