public class Renderer {

  private static final int DAWN = 6;
  private static final int DUSK = 18;

  public void printWorld(String[] map, Player player, GameWorld world, Visualizer visualizer) {
    clearScreen();
    printSky(world, visualizer);
    int viewPort = world.getViewPort();
    int visualRange = world.getVisualRange();
    int rowStart = Math.max(0, player.getRow() - viewPort);
    int rowEnd = Math.min(map.length, player.getRow() + viewPort + 1);
    int colStart = Math.max(0, player.getColumn() - viewPort);
    int colEnd = Math.min(map[0].length(), player.getColumn() + viewPort + 1);

    for (int i = rowStart; i < rowEnd; i++) {
      for (int j = colStart; j < colEnd; j++) {
        double distance = Math.sqrt(Math.pow(i - player.getRow(), 2) + Math.pow(j - player.getColumn(), 2));
        if (distance <= visualRange) {
          if (i == player.getRow() && j == player.getColumn()) {
            System.out.print(visualizer.mapElement('P', world.getVisualizationMode()));
          } else {
            char elem = map[i].charAt(j);
            System.out.print(visualizer.mapElement(elem, world.getVisualizationMode()));
          }
        } else {
          System.out.print(visualizer.GRAY_BACKGROUND + "   " + visualizer.RESET);
        }
      }
      System.out.println();
    }
    printStatus(player, world);
  }

  private void printSky(GameWorld world, Visualizer visualizer) {
    double time = world.getTime();
    int viewPortSize = world.getViewPort() * 2 + 1;
    int sunPosition = calculateSunPosition(time, viewPortSize);

    for (int i = 0; i < viewPortSize; i++) {
      if (time > DAWN && time <= DUSK && i == sunPosition) {
        System.out.print(visualizer.mapElement('S', world.getVisualizationMode()));
      } else {
        System.out.print(visualizer.mapElement('C', world.getVisualizationMode()));
      }
    }
    System.out.println();
    System.out.println();

  }

  private int calculateSunPosition(double time, int viewPortSize) {
    if (time < DAWN || time > DUSK) {
      return -1;
    }
    return (int) ((time - DAWN) / (DUSK - DAWN) * viewPortSize) % viewPortSize;
  }

  private void printStatus(Player player, GameWorld world) {
    System.out.println(
        "Time: [" + (int) world.getTime() + "] / Position: (" + player.getColumn() + "," + player.getRow()
            + ") / Skin: ("
            + world.getVisualizationMode() + ")");
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static final String RESET = "\033[0m";
}
