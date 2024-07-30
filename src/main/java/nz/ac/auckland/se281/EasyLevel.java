package nz.ac.auckland.se281;

public class EasyLevel implements AiDifficulty {
  private Strategy randomStrategy = new RandomStrategy();

  private int fingers;

  @Override
  public int fingers() {
    fingers = randomStrategy.fingers();
    return fingers;
  }

  @Override
  public int sum() {
    return randomStrategy.sum(fingers);
  }
}
