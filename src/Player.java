public class Player {

    private int totalScore;
    private int roundScore;
    private Dice dice;
    private Turn player;

    public Player(Turn player) {
        totalScore = 0;
        roundScore = 0;
        this.player = player;
        this.dice = new Dice();
    }

    public Dice roll() {
        dice.rollDice();
        return dice;
    }

    public Turn getPlayer() {
        return player;
    }

    public void addRound() {
        roundScore += dice.getTotal();
    }

    public void clearRound() {
        roundScore = 0;
    }

    public void clearTotal() {
        totalScore = 0;
    }

    public int getScore() { return totalScore; }

}
