public class GrayImage {
    public static final int Black = 0;
    public static final int WHITE = 255;

    private int[][] pixelValues;

    public int countWhitePixels() {
        int count = 0;

        for (int[] r : this.pixelValues) {
            for (int c : r) {
                if (this.pixelValues[r][c] == WHITE) {
                    count++;
                }
            }
        }

        return count;
    }

    public void processImage() {
        for (int r = 0; r < this.pixelValues.length-2; r++) {
            for (int c = 0; c < this.pixelValues[0].length-2; c++) {
                this.pixelValues[r][c] -= this.pixelValues[r+2][c+2];
                if (this.pixelValues[r][c] < Black) {
                    this.pixelValues[r][c] = BLACK;
                }
            }
        }
    }
}
