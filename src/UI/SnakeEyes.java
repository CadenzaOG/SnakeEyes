package UI;

import asciiPanel.AsciiPanel;
import assets.Assets;
import core.*;
import panels.*;
import utils.Cell;
import utils.Utils;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SnakeEyes implements Screen, GameListener {


    private Cell[][] display;
    private final char[][] gameBoard = Utils.stringArraytoCharArray(Assets.gameBoard);
    private final char[][] logo = Utils.addBorders(Assets.snakeEyesLogo);
    private HashMap<Turn, Player> players;
    private Turn turn;
    private Player currentPlayer;
    private ArrayList<Panel> panels;
    private ArrayList<PlayerPanel> playerPanels;
    private DicePanel dicePanel;
    private GameController gameController;


    public SnakeEyes(int h, int w) {
        // Generate players, set first turn to player one

        this.gameController = new SnakeEyesController();
        gameController.setStateListener(this);
        display = Utils.newEmptyGrid(h, w);
        playerPanels = new ArrayList<>();
        panels = new ArrayList<>();
        players = new HashMap<>();
        for (Turn t : Turn.values()) {
            players.put(t, new Player(t));
        }
        this.turn = Turn.PLAYER_ONE;
        this.currentPlayer = players.get(Turn.PLAYER_ONE);
        Logo logo = new Logo(2, 1, 10, 58);
        Background bg = new Background(7, 12, 9, 49);
        PlayerPanel playerOnePanel = new PlayerPanel(32,13,3,10, players.get(Turn.PLAYER_ONE));
        PlayerPanel playerTwopanel = new PlayerPanel(32, 17, 3, 10, players.get(Turn.PLAYER_TWO));
        panels.add(logo);
        panels.add(bg);
        panels.add(playerOnePanel);
        panels.add(playerTwopanel);
        playerPanels.add(playerOnePanel);
        playerPanels.add(playerTwopanel);
        playerOnePanel.setColor(turn);
        playerTwopanel.setColor(turn);
        this.dicePanel = new DicePanel();
        panels.add(dicePanel);
        renderPanels(panels);

        //drawPanel(logo, 2, 1);
        // drawPanel(gameBoard, 7, 12);
    }

    private void initPanels() {

    }

    public void updatePlayerPanels(ArrayList<PlayerPanel> p ) {
        for (PlayerPanel pl: p) {
            pl.setColor(turn);
            pl.setScore();
        }
    }

    public void renderPanels(ArrayList<Panel> panels) {
        for (Panel p: panels) {
            for (int h = 0; h < p.getHeight(); h++) {
                for (int w = 0; w < p.getWidth(); w++) {
                    Cell cell = p.getContent()[h][w];
                    display[h + p.getY()][w + p.getX()] = cell;
                }
            }
        }
    }

    public void drawPanel(char[][] asset, int offsetX, int offsetY) {
        for (int i = 0; i < asset.length; i++) {
            for (int j = 0; j < asset[i].length; j++) {
                Cell cell = new Cell();
                cell.setGlyph(asset[i][j]);
                display[i + offsetY][j + offsetX] = cell;
            }
        }
    }

    public void start() {

        //printLogo();
        currentPlayer = players.get(turn);

        turn:
        while (turn == currentPlayer.getPlayer()) {

        }
    }


    public void roll() {
        currentPlayer.roll();
    }


    public void nextPlayerTurn() {
        if (turn == Turn.PLAYER_ONE) {
            turn = Turn.PLAYER_TWO;
        } else {
            turn = Turn.PLAYER_ONE;
        }
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        for (int height = 0; height < display.length; height++) {
            for (int width = 0; width < display[0].length; width++) {
                Cell cell = display[height][width];
                terminal.write(cell.getGlyph(), width, height, cell.getColor());
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
       switch (key.getKeyCode()) {
           case KeyEvent.VK_ENTER: {
               currentPlayer.roll();
               dicePanel.updateDice(currentPlayer.getDice());
               nextPlayerTurn();
               players.get(turn).incrementScore();
               updatePlayerPanels(playerPanels);
           }
           renderPanels(panels);
       }
        return this;
    }



    }

