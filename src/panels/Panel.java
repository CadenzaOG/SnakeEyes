package panels;


import utils.Cell;
import utils.Utils;

public abstract class Panel {

    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected Cell[][] content;
    protected boolean isUpdated;

    public Panel(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        content = Utils.newEmptyGrid(height, width);
        this.isUpdated = true;
    }

    public void drawPanel(char[][] asset, int posX, int posY) {
        for (int i = 0; i < asset.length; i++) {
            for (int j = 0; j < asset[i].length; j++) {
                Cell cell = new Cell();
                cell.setGlyph(asset[i][j]);
                content[i + posY][j + posX] = cell;
            }
        }
    }

    public void drawPanel(char[][] asset) {
       drawPanel(asset, 0,0);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    protected Panel() {
    }

    public Cell[][] getContent() {
        return content;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isUpdated() {
        return isUpdated;
    }


}
