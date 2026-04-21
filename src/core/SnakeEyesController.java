package core;

import java.util.ArrayList;
import java.util.HashMap;

public class SnakeEyesController implements GameController {

    private GameListener listener;
    private HashMap<Turn, Player> players;
    private Turn currentTurn;
    private Gamestate state;

    public SnakeEyesController() {
        players = new HashMap<>();
        for (Turn t : Turn.values()) {
            players.put(t, new Player(t));
        }
        this.currentTurn = Turn.PLAYER_ONE;
    }


    public Player getPlayer(Turn turn) {
        return players.get(turn);
    }


    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }

    public void rollDice() {

    }

    public void hold() {

    }

    public void notifyListener() {
        if (listener != null) {
            listener.onStateChange(this);
        }
    }

    @Override
    public void setStateListener(GameListener listener) {
        this.listener = listener;
    }
}
