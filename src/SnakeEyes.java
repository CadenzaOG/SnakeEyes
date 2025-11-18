import asciiPanel.AsciiCharacterData;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.KeyListener;

public class SnakeEyes implements Screen {


    private Cell[][] display;
    private final char[][] gameBoard = Utils.stringArraytoCharArray(Assets.gameBoard);
    private final char[][] logo = Utils.addBorders(Assets.snakeEyesLogo);
    private HashMap<Turn, Player> players;
    private Turn turn;
    private Player currentPlayer;
    private ArrayList<Panel> panels;
    private ArrayList<PlayerPanel> playerPanels;


    public SnakeEyes(int h, int w) {
        // Generate players, set first turn to player one
        display = Utils.newEmptyGrid(h, w);
        playerPanels = new ArrayList<>();
        panels = new ArrayList<>();
        players = new HashMap<>();
        for (Turn t : Turn.values()) {
            players.put(t, new Player(t));
        }
        this.turn = Turn.PLAYER_ONE;
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
        renderPanels(panels);
        //drawPanel(logo, 2, 1);
        // drawPanel(gameBoard, 7, 12);
    }

    public void updatePlayerPanels(ArrayList<PlayerPanel> p ) {
        for (PlayerPanel pl: p) {
            pl.setColor(turn);
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


            /*

    TURN:
        Roll dice
        If either die = 1 turn is over and accumulated points lost.
        If both die = 1 player losts all points accumulated in game and the turn is over.
        Sum points together and add to total for turn
        Player chooses if they wish to roll again.

    First to 100 wins.

 */


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
           case KeyEvent.VK_ENTER: nextPlayerTurn(); updatePlayerPanels(playerPanels);
       }
        return this;
    }
    /*


    public void printLogo() {

        for (String s: logo) {
            System.out.println(s);
        }
    }

     */


    }

