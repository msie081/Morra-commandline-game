package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {
  private Player player;

  // Create constructor to take in an instance of the player class input and set the player
  // accordingly
  public AverageStrategy(Player player) {
    this.player = player;
  }

  @Override
  public int fingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  // This method will calculate the average of the previous fingers after the third round for the
  // human player, ensuring it will round to the nearest integer and then add it to fingers for sum
  public int sum(int fingers) {
    double total = 0;
    int sum;
    // Loop through the array of fingers for the human player and adds them together
    for (int i = 0; i < this.player.getFingerArray().size() - 1; i++) {
      total += this.player.getFingerArray().get(i);
    }
    // Calculate the average of the previous fingers for the number of rounds played
    int average = (int) Math.round(total / (this.player.getFingerArray().size() - 1));
    sum = (int) average + fingers;
    return sum;
  }
}
