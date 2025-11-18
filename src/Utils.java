public class Utils {

    private Utils() {  }

    public static char[][] stringArraytoCharArray(String[] input) {
        int maxwidth = 0;
        for (String s: input) {
            maxwidth = Math.max(maxwidth, s.length());
        }

        char[][] output = new char[input.length][maxwidth];

        for (int i = 0; i < input.length; i++) {
            output[i] = input[i].toCharArray();
        }

        return output;
    }



    public static Cell[][] newEmptyGrid(int h, int w) {
        Cell[][] output = new Cell[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = new Cell();
            }
        }
        return output;
    }

    public static char[][] addBorders(String[] input) {

        char[][] asset = stringArraytoCharArray(input);
        int width = asset[0].length;
        int height = asset.length;
        int horizontalPadding = 2;
        int verticalPadding = 1;

        char[][] output = new char[height + horizontalPadding * 2 + 2][width + verticalPadding * 2 + 2];

        char topLeft = (char) 201; // ╔
        char topRight = (char) 187; // ╗
        char botLeft = (char) 200; // ╚
        char botRight = (char) 188; // ╝
        char horiz = (char) 205; // ═
        char vert  = (char) 186; // ║

        int outHeight = output.length - 1;
        int outWidth = output[0].length - 1;

        for (int h = 0; h < output.length; h++) {
            for (int w = 0; w < output[h].length; w++) {
                try {
                    if (h == 0 && w == 0) output[h][w] = topLeft;
                    else if (h == 0 && w == outWidth) output[h][w] = topRight;
                    else if (h == outHeight && w == 0) output[h][w] = botLeft;
                    else if (h == outHeight && w == outWidth) output[h][w] = botRight;
                    else if (h == 0 || h == outHeight) output[h][w] = horiz;
                    else if (w == 0 || w == outWidth) output[h][w] = vert;
                    else {
                        int assetRow = h - horizontalPadding - 1;
                        int assetCol = w - verticalPadding - 1;
                        if (assetRow >= 0 &&
                                assetRow < height &&
                                assetCol >= 0 &&
                                assetCol < width) {
                            output[h][w] = asset[assetRow][assetCol];
                        } else {
                            output[h][w] = ' ';
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error at h=" + h + ", w=" + w);
                    System.out.println("Trying to access: assetRow=" + (h - horizontalPadding - 1) +
                            ", assetCol=" + (w - verticalPadding - 1));
                    throw e;
                }
            }
        }
        return output;
    }
}
