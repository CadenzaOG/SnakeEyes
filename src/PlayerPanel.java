import asciiPanel.AsciiCharacterData;
import asciiPanel.AsciiPanel;

import java.awt.*;

public class PlayerPanel extends Panel {

    private final Color activeColor = AsciiPanel.green;
    private final Color inactiveColor = Color.lightGray;
    private final Player player;
    private final String text;
    private Color currentColor;
    private int score;

    public PlayerPanel(int x, int y, int height, int width, Player player) {
        super(x, y, height, width);
        this.player = player;
        text = player.getPlayer().toString();
        score = player.getScore();
        initialise();

    }

    private void initialise() {
        writeTextToLine(0, text, currentColor, 0);
        updateScoreLine();
        isUpdated = true;
    }

    public void setColor(Turn turn) {
        if (player.getPlayer() == turn) {
            currentColor = activeColor;
        } else {
            currentColor = inactiveColor;
        }

        for (int i = 0; i < text.length(); i++) {
            content[0][i].setColor(currentColor);
        }
        isUpdated = true;
    }


    private void writeTextToLine(int lineIndex, String text, Color color, int spacer) {
        for (int i = 0; i < text.length(); i++) {
            content[lineIndex][i + spacer].setGlyph(text.charAt(i));
            content[lineIndex][i + spacer].setColor(color);
        }
    }

    private void updateScoreLine() {
        String scoreText;
        scoreText = Integer.toString(player.getScore());
        writeTextToLine(2, scoreText, AsciiPanel.yellow, 3);
    }



    public void setScore() {
        updateScoreLine();
        isUpdated = true;
    }


}
