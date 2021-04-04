class Square {
    public Square(boolean isBlack, int num) {
    }
}

class Crossword {
    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares) {
        int length = blackSquares.length;
        int width = blackSquares[0].length;
        int label = 1;

        this.puzzle = new Square[length][width];
        
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < width; c++) {
                this.puzzle[r][c] = new Square(blackSquares[r][c], this.toBeLabeled(r, c, blackSquares) ? label++ : 0);
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        return !blackSquares[r][c] && (blackSquares[r-1][c] || blackSquares[r][c-1]);
    }
} 
