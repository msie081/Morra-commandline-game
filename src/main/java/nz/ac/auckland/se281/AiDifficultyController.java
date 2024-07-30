package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiDifficultyController {

  // Create a method to create a difficulty based on the type of difficulty and take in the player
  // input
  public AiDifficulty createDifficulty(Difficulty type, Player player) {
    // Create a switch statement to create a difficulty based on the type of difficulty
    switch (type) {
      case EASY:
        // Return a new instance of the EasyLevel class
        return new EasyLevel();

      case MEDIUM:
        // Return a new instance of the MediumLevel class
        return new MediumLevel(player);

      case HARD:
        // Return a new instance of the HardLevel class
        return new HardLevel(player);

      case MASTER:
        // Return a new instance of the MasterLevel class
        return new MasterLevel(player);
    }
    return null;
  }
}
