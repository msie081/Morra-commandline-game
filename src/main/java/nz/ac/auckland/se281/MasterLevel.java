package nz.ac.auckland.se281;

public class MasterLevel implements AiDifficulty {

  private Player player;
  private Strategy strategy = new RandomStrategy();
  private int fingers;
  private int round = 1;

  // Create constructor to take in an instance of the player class input and set the player
  // accordingly
  public MasterLevel(Player player) {
    this.player = player;
  }

  @Override
  public int fingers() {
    // Swap strategy after the third round
    if (round == 4) {
      swapStrategyAverage();
    }
    // Alternate between the two strategies - TopStrategy and Average Strategy, after the fourth
    // round
    if (round > 4) {
      if (strategy instanceof TopStrategy) {
        swapStrategyAverage();
      } else {
        swapStrategyTop();
      }
    }
    // Increment the round and find fingers based on the strategy
    round++;
    fingers = strategy.fingers();
    return fingers;
  }

  @Override
  public int sum() {
    return strategy.sum(fingers);
  }

  // Method to swap strategy to AverageStrategy
  private void swapStrategyAverage() {
    this.strategy = new AverageStrategy(player);
  }

  // Method to swap strategy to TopStrategy
  private void swapStrategyTop() {
    this.strategy = new TopStrategy(player);
  }
}
