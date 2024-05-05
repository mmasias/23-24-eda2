import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameWorld {
  private int minRow, minColumn, maxRow, maxColumn;
  private double time;
  private int visualRange;
  private int viewPort;
  private int visualizationMode;
  private String lastPathMessage;

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

  private boolean findPath(String[] map, int startX, int startY, int goalX, int goalY, HashSet<String> visited) {
    String posKey = startX + "," + startY;
    if (startX < 0 || startY < 0 || startX >= map.length || startY >= map[0].length()
        || map[startX].charAt(startY) == '0' || visited.contains(posKey)) {
      return false; // Invalid start position or visited
    }
    if (startX == goalX && startY == goalY) {
      // Goal reached
      pathTaken.add(new int[] { startX, startY });
      return true;
    }

    visited.add(posKey);

    // Attempt to move in all valid directions
    int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    for (int[] move : moves) {
      int newX = startX + move[0];
      int newY = startY + move[1];
      if (findPath(map, newX, newY, goalX, goalY, visited)) {
        // Path found, add current position to pathTaken list
        pathTaken.add(0, new int[] { startX, startY });
        return true;
      }
    }

    visited.remove(posKey);
    return false;
  }

  public String getLastPathMessage() {
    return lastPathMessage;
  }

  public boolean solveMaze(String[] map, int startX, int startY, int goalX, int goalY) {
    pathTaken.clear();
    HashSet<String> visited = new HashSet<>();
    boolean result = findPath(map, startX, startY, goalX, goalY, visited);
    if (result) {
      lastPathMessage = "Path found. Press 'b' to start moving.";
    } else {
      lastPathMessage = "No path available.";
    }
    return result;
  }

  public List<int[]> getPathTaken() {
    return pathTaken;
  }

  public void resetPath() {
    pathTaken.clear();
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
