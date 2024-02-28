import java.util.ArrayList;

class Day {
  private ArrayList<Intake> intakes;

  public Day() {
      intakes = new ArrayList<>();
  }

  public void addIntake(Intake intake) {
      intakes.add(intake);
  }

  public void updateIntake(Intake intake, int index) {
      intakes.set(index, intake);
  }

  public void deleteIntake(int index) {
      intakes.remove(index);
  }

  @Override
  public String toString() {
      StringBuilder intakeListing = new StringBuilder();
      for (Intake intake : intakes) {
          intakeListing.append(intake.toString()).append("\n");
      }
      return intakeListing.toString();
  }
}