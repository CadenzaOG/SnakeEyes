package panels;

public class DicePanel extends Panel {

    public DicePanel() {
        super(19, 13, 6, 11);
        drawPanel(Assets.DieFaces.values()[2].getFace(), 1, 1);
        drawPanel(Assets.DieFaces.FIVE.getFace(),6, 3); // Y + 3 ,
    }

    public void updateDice(Dice dice) {
        for (int i: dice.getDice()) {

        }
    }




}
