import java.util.HashMap;

public class Visualizer {

  private HashMap<Character, String[]> visualizationMapping;

  public Visualizer() {
    initializeMappings();
  }

  private void initializeMappings() {
    visualizationMapping = new HashMap<>();

    visualizationMapping.put(' ',
        new String[] { BLUE_BOLD_BRIGHT + BLUE_BACKGROUND_BRIGHT + " ~~ " + RESET, " ~~ ", " ", "1" });
    visualizationMapping.put('.',
        new String[] { YELLOW_BRIGHT + GREEN_BACKGROUND + " . ." + RESET, " . .", ".", "0" });
    visualizationMapping.put('-',
        new String[] { WHITE + WHITE_BACKGROUND + "[##]" + RESET, "[##]", "-", "1" });
    visualizationMapping.put('=',
        new String[] { BLACK_BACKGROUND_BRIGHT + "||||" + RESET, "||||", "=", "0" });
    visualizationMapping.put('|',
        new String[] { WHITE + WHITE_BACKGROUND + "[##]" + RESET, "[##]", "|", "1" });
    visualizationMapping.put(':',
        new String[] { YELLOW_BRIGHT + GREEN_BACKGROUND + "oO*o" + RESET, "oO*o", ":", "0" });
    visualizationMapping.put('+',
        new String[] { GREEN_BOLD + YELLOW_BACKGROUND + "..:." + RESET, "..:.", "+", "0" });
    visualizationMapping.put('O',
        new String[] { WHITE_BACKGROUND_BRIGHT + "[  ]" + RESET, "[  ]", "O", "0" });
    visualizationMapping.put('#',
        new String[] { BLACK + RED_BACKGROUND + "::::" + RESET, "::::", "#", "0" });
    visualizationMapping.put('*',
        new String[] { YELLOW + YELLOW_BACKGROUND + "    " + RESET, "    ", "*", "0" });
    visualizationMapping.put('$',
        new String[] { RED_BRIGHT + YELLOW_BACKGROUND + "$$$$" + RESET, "$$$$", "$", "0" });
    visualizationMapping.put('X',
        new String[] { RED_UNDERLINED + YELLOW_BACKGROUND + "||||" + RESET, "||||", "X", "0" });
    visualizationMapping.put('%',
        new String[] { GREEN_BOLD + YELLOW_BACKGROUND + "%%%%" + RESET, "%%%%", "%", "0" });
    visualizationMapping.put('_',
        new String[] { BLACK + "____" + RESET, "____", "_", "0" });
    visualizationMapping.put('~',
        new String[] { BLUE_BACKGROUND_BRIGHT + " ~ ~" + RESET, " ~ ~", "~", "1" });
    visualizationMapping.put('B',
        new String[] { BLUE + BLUE_BACKGROUND + "====" + RESET, "====", "B", "0" });
    visualizationMapping.put('P',
        new String[] { RED + "_()_" + RESET, "_()_", "P", "*" });
    visualizationMapping.put('D',
        new String[] { BLACK_BACKGROUND_BRIGHT + "    " + RESET, "    ", "D", "0" });
    visualizationMapping.put('S',
        new String[] { YELLOW_BOLD_BRIGHT + BLUE_BACKGROUND + " () " + RESET, " () ", "S", "0" });
    visualizationMapping.put('C',
        new String[] { BLUE_BACKGROUND + "    " + RESET, "    ", "C", "0" });
  }

  public String mapElement(char element, int mode) {
    if (visualizationMapping.containsKey(element)) {
      return visualizationMapping.get(element)[mode];
    }
    return String.valueOf(element);
  }

  public static final String RESET = "\033[0m";

  public static final String BLACK = "\033[0;30m";
  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String YELLOW = "\033[0;33m";
  public static final String BLUE = "\033[0;34m";
  public static final String PURPLE = "\033[0;35m";
  public static final String CYAN = "\033[0;36m";
  public static final String WHITE = "\033[0;37m";

  public static final String BLACK_BOLD = "\033[1;30m";
  public static final String RED_BOLD = "\033[1;31m";
  public static final String GREEN_BOLD = "\033[1;32m";
  public static final String YELLOW_BOLD = "\033[1;33m";
  public static final String BLUE_BOLD = "\033[1;34m";
  public static final String PURPLE_BOLD = "\033[1;35m";
  public static final String CYAN_BOLD = "\033[1;36m";
  public static final String WHITE_BOLD = "\033[1;37m";

  public static final String BLACK_UNDERLINED = "\033[4;30m";
  public static final String RED_UNDERLINED = "\033[4;31m";
  public static final String GREEN_UNDERLINED = "\033[4;32m";
  public static final String YELLOW_UNDERLINED = "\033[4;33m";
  public static final String BLUE_UNDERLINED = "\033[4;34m";
  public static final String PURPLE_UNDERLINED = "\033[4;35m";
  public static final String CYAN_UNDERLINED = "\033[4;36m";
  public static final String WHITE_UNDERLINED = "\033[4;37m";

  public static final String BLACK_BACKGROUND = "\033[40m";
  public static final String RED_BACKGROUND = "\033[41m";
  public static final String GREEN_BACKGROUND = "\033[42m";
  public static final String YELLOW_BACKGROUND = "\033[43m";
  public static final String BLUE_BACKGROUND = "\033[44m";
  public static final String PURPLE_BACKGROUND = "\033[45m";
  public static final String CYAN_BACKGROUND = "\033[46m";
  public static final String WHITE_BACKGROUND = "\033[47m";

  public static final String BLACK_BRIGHT = "\033[0;90m";
  public static final String RED_BRIGHT = "\033[0;91m";
  public static final String GREEN_BRIGHT = "\033[0;92m";
  public static final String YELLOW_BRIGHT = "\033[0;93m";
  public static final String BLUE_BRIGHT = "\033[0;94m";
  public static final String PURPLE_BRIGHT = "\033[0;95m";
  public static final String CYAN_BRIGHT = "\033[0;96m";
  public static final String WHITE_BRIGHT = "\033[0;97m";

  public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
  public static final String RED_BOLD_BRIGHT = "\033[1;91m";
  public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
  public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
  public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
  public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
  public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
  public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

  public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
  public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
  public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
  public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
  public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
  public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
  public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
  public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
}
