package nz.ac.auckland.se281;

public class MediumLevel implements AiDifficulty {

  private Player player;

  private Strategy strategy = new RandomStrategy();

  private int fingers;
  private int round = 1;

  // Create constructor to take in an instance of the player class input and set the player
  // accordingly
  public MediumLevel(Player player) {
    this.player = player;
  }

  @Override
  public int fingers() {
    if (round == 4) {
      swapStrategy();
    }
    fingers = strategy.fingers();
    round++;
    return fingers;
  }

  @Override
  public int sum() {
    return strategy.sum(fingers);
  }

  private void swapStrategy() {
    this.strategy = new AverageStrategy(player);
  }
}
