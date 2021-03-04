class LightBoard {
  private boolean[][] lights;

  public LightBoard(int rows, int columns) {
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (Math.random() < 0.4) this.lights[row][column] = true;
        else this.lights[row][column] = false;
      }
    }
  }

  public boolean evaluateLight(int row, int column) {
    if (this.lights[row][column]) {
      if ((countOn(column) % 2) == 0) return false;
    }
    else {
      if ((countOn(column) % 3) == 0) return true;
    }
    return this.lights[row][column];
  }

  public int countOn(int column) {
    int ons = 0;
    for (int row = 0; row < this.lights.length; row++) {
      if (this.lights[row][column]) ons++;
    }
    return ons;
  }
}