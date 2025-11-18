import java.awt.*;

public class Cell {

    private char glyph;
    private Color color;

    public Cell() {
        this.glyph = ' ';
        this.color = Color.WHITE;
    }

    public void setGlyph(char c) {
        glyph = c;
    }

    public void setColor(Color c) {
        color = c;
    }

    public char getGlyph() { return glyph; }

    public Color getColor() { return color;}
}
