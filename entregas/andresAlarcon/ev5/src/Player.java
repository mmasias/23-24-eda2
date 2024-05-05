import java.util.HashMap;
import java.util.List;

public class Player {
  private int row, column;
  private HashMap<Character, String> terrainMapping;

  public Player(int row, int column) {
    this.row = row;
    this.column = column;
    initializeTerrainMapping();
  }

  public void followPath(List<int[]> path, Renderer renderer, String[] map, GameWorld world, Visualizer visualizer) {
    for (int[] step : path) {
      moveTo(step[0], step[1]);
      renderer.clearScreen();
      renderer.printWorld(map, this, world, visualizer);
      try {
        Thread.sleep(500); // 500 milliseconds delay for each step
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public void setPosition(int x, int y) {
    this.row = x;
    this.column = y;
  }

  private void initializeTerrainMapping() {
    terrainMapping = new HashMap<>();
    terrainMapping.put(' ', "1");
    terrainMapping.put('.', "0");
    terrainMapping.put('-', "1");
    terrainMapping.put('=', "0");
    terrainMapping.put('|', "1");
    terrainMapping.put(':', "0");
    terrainMapping.put('+', "0");
    terrainMapping.put('O', "0");
    terrainMapping.put('#', "0");
    terrainMapping.put('*', "0");
    terrainMapping.put('$', "0");
    terrainMapping.put('X', "0");
    terrainMapping.put('%', "0");
    terrainMapping.put('_', "0");
    terrainMapping.put('~', "1");
    terrainMapping.put('B', "0");
    terrainMapping.put('P', "*");
    terrainMapping.put('D', "0");
    terrainMapping.put('S', "0");
    terrainMapping.put('C', "0");
  }

  public void move(int direction, String[] map, GameWorld world) {
    int oldRow = row;
    int oldColumn = column;

    switch (direction) {
      case 0:
        row--;
        break;
      case 1:
        row++;
        break;
      case 2:
        column--;
        break;
      case 3:
        column++;
        break;
    }

    if (row < 0 || row >= map.length || column < 0 || column >= map[0].length()
        || !isWalkable(map[row].charAt(column))) {
      row = oldRow;
      column = oldColumn;
    }
  }

  public void moveTo(int newX, int newY) {
    this.row = newX;
    this.column = newY;
  }

  private boolean isWalkable(char terrain) {
    return terrainMapping.getOrDefault(terrain, "1").equals("0");
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

}
