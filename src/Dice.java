import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Dice implements Printable {

    private static final String BAR = "+-------+";
    private static final String LSE = "|  ";
    private static final String LSF = "| o";
    private static final String RSE = "  |";
    private static final String RSF = "o |";
    private static final String CE = "   ";
    private static final String CF = " o ";

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

    public void printDice() {
        for (String s : this.render()) {
            System.out.println(s);
        }
    }

    public int[] getDice() {
        return dice;
    }

    public int getTotal() {
        return Arrays.stream(dice).sum();
    }

    private String[] buildDieFace(int value) {
        String[] diceFace = new String[5];
        diceFace[0] = BAR;
        diceFace[4] = BAR;
        switch (value) {
            case 1: diceFace[1] = LSE + CE + RSE; diceFace[2] = LSE + CF + RSE; diceFace[3]  = LSE + CE + RSE; break;
            case 2: diceFace[1] = LSE + CE + RSF; diceFace[2] = LSE + CE + RSE; diceFace[3]  = LSF + CE + RSE; break;
            case 3: diceFace[1] = LSE + CE + RSF; diceFace[2] = LSE + CF + RSE; diceFace[3]  = LSF + CE + RSE; break;
            case 4: diceFace[1] = LSF + CE + RSF; diceFace[2] = LSE + CE + RSE; diceFace[3]  = LSF + CE + RSF; break;
            case 5: diceFace[1] = LSF + CE + RSF; diceFace[2] = LSE + CF + RSE; diceFace[3]  = LSF + CE + RSF; break;
            case 6: diceFace[1] = LSF + CE + RSF; diceFace[2] = LSF + CE + RSF; diceFace[3]  = LSF + CE + RSF; break;
        }
        return diceFace;
    }

    public String[] render() {
        String[] dieOne = buildDieFace(dice[0]);
        String[] dieTwo = buildDieFace(dice[1]);
        String[] output = new String[5];
        for (int i = 0; i < dieOne.length; i++) {
            output[i] = dieOne[i] + "    " + dieTwo[i];
        }
        return output;
    }



}





