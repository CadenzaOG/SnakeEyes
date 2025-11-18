/*
    Author: Sean Boa
    Year: 2025
    SNAKE EYES

 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import jdk.jshell.execution.Util;
import javax.swing.JFrame;

 public class Main extends JFrame implements KeyListener {

        public AsciiPanel terminal;
        private Screen screen;

        public Main() {
            super();
            terminal = new AsciiPanel(62, 25);
            terminal.setAsciiFont(AsciiFont.CP437_16x16);
            add(terminal);
            pack();
            screen = new SnakeEyes(terminal.getHeightInCharacters(), terminal.getWidthInCharacters());
            addKeyListener(this);
            repaint();
        }

        public void repaint() {
            terminal.clear();
            screen.displayOutput(terminal);
            super.repaint();
        }


     @Override
     public void keyTyped(KeyEvent e) {

     }

     @Override
     public void keyPressed(KeyEvent e) {
         screen.respondToUserInput(e);
         repaint();
     }

     @Override
     public void keyReleased(KeyEvent e) {

     }


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setVisible(true);

    }


 }



