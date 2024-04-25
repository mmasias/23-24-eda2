import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameWorld {
  private int minRow, minColumn, maxRow, maxColumn;
  private double time;
  private int visualRange;
  private int viewPort;
  private int visualizationMode;

  private List<int[]> pathTaken = new ArrayList<>();

  public GameWorld(String[] map, int viewPort, int visualizationMode) {
    this.viewPort = viewPort;
    this.visualizationMode = visualizationMode;
    this.time = 9.0;
    this.minRow = viewPort;
    this.minColumn = viewPort;
    this.maxRow = map.length - viewPort;
    this.maxColumn = map[0].length() - viewPort;
    calculateVisualRange();
  }

  private boolean findPath(String[] map, int x, int y, int goalX, int goalY, HashSet<String> visited) {
    String posKey = x + "," + y;
    if (x < 0 || y < 0 || x >= map.length || y >= map[0].length())
      return false;
    if (map[x].charAt(y) == '0' || visited.contains(posKey))
      return false; // '0' is a wall or visited
    if (x == goalX && y == goalY) {
      pathTaken.add(new int[] { x, y });
      return true;
    }

    visited.add(posKey);

    int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    for (int[] move : moves) {
      int newX = x + move[0];
      int newY = y + move[1];
      if (findPath(map, newX, newY, goalX, goalY, visited)) {
        pathTaken.add(0, new int[] { x, y });
        return true;
      }
    }

    visited.remove(posKey);
    return false;
  }

  public boolean solveMaze(String[] map, int startX, int startY, int goalX, int goalY) {
    pathTaken.clear();
    HashSet<String> visited = new HashSet<>();
    return findPath(map, startX, startY, goalX, goalY, visited);
  }

  public List<int[]> getPathTaken() {
    return pathTaken;
  }


  public void updateTime() {
    time += 0.2;
    if (time >= 24)
      time = 0;
    calculateVisualRange();
  }

  private void calculateVisualRange() {
    visualRange = viewPort * 2;

    if (time < 1 || time > 23) {
      visualRange = 1;
    } else if (time < 3 || time > 21) {
      visualRange = visualRange / 5;
    } else if (time < 4 || time > 20) {
      visualRange = (visualRange / 5) * 2;
    } else if (time < 5 || time > 19) {
      visualRange = (visualRange / 5) * 3;
    } else if (time < 6 || time > 18) {
      visualRange = (visualRange / 5) * 4;
    }
  }

  public int getViewPort() {
    return viewPort;
  }

  public double getTime() {
    return time;
  }

  public int getVisualRange() {
    return visualRange;
  }

  public int getVisualizationMode() {
    return visualizationMode;
  }

  public void changeVisualizationMode() {
    visualizationMode = (visualizationMode + 1) % 4;
  }

  public int getMinRow() {
    return minRow;
  }

  public int getMaxRow() {
    return maxRow;
  }

  public int getMinColumn() {
    return minColumn;
  }

  public int getMaxColumn() {
    return maxColumn;
  }
}
