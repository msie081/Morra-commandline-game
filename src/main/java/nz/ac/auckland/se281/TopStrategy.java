package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private Player player;

  // Create constructor to take in an instance of the player class input and set the player
  // accordingly
  public TopStrategy(Player player) {
    this.player = player;
  }

  @Override
  public int fingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  // Method to find the most frequently occuring number in the players finger array and add it to
  // the fingers for the computer, which will be the sum for the round
  public int sum(int fingers) {
    int topNumber = 0;
    int topMaxCount = 0;
    // Loop through the array of fingers for the human player
    for (int i = 0; i < this.player.getFingerArray().size() - 1; i++) {
      int count = 0;
      // Loop through the array of fingers for the human player again to compare the current number
      for (int j = 0; j < this.player.getFingerArray().size() - 1; j++) {
        // If the current number is equal to the number in the array, increment the count
        if (this.player.getFingerArray().get(i) == this.player.getFingerArray().get(j)) {
          count++;
        }
        // If the count is greater than the top max count, set the topMaxCount to the count and
        // topNumer as the current number
        if (count > topMaxCount) {
          topMaxCount = count;
          topNumber = this.player.getFingerArray().get(i);
        }
      }
    }
    // Add the top number to the fingers for the computer, which will be the sum for the round
    topNumber += fingers;
    return topNumber;
  }
}
