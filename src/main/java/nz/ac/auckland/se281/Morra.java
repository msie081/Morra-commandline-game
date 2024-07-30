package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round = 1;
  private Player player;
  private Player computer;
  private AiDifficulty difficultyLevel;
  private int fingerComputer;
  private int sumComputer;
  private int started = 0;
  private int pointsToWin;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Create a new player and set the username as options[0]
    this.player = new Player();
    player.setUsername(options[0]);
    this.computer = new Player();
    computer.setUsername("Jarvis");
    // Saving the difficulty to be used when playing against the computer
    AiDifficultyController controller = new AiDifficultyController();
    this.difficultyLevel = controller.createDifficulty(difficulty, this.player);
    started = 1;
    // If newGame is started again, reset the rounds to 1
    round = 1;
    this.pointsToWin = pointsToWin;
  }

  public void play() {
    // Check if the game has started, else print error message
    if (started != 1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // Start the round and save user inputs into the input, and split the input into 2 integers in
    // the string array
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    String[] option = input.split(" ");
    // While the conditions have yet to be meant, check if the player inputted 2 integer numbers
    // which meet the criteria
    int conditions = 0;
    while (conditions == 0) {
      if (option.length == 2) {
        if ((Integer.parseInt(option[0]) <= 5)
            && (Integer.parseInt(option[0]) >= 1)
            && (Integer.parseInt(option[1]) <= 10)
            && (Integer.parseInt(option[1]) >= 1)) {
          // If conditions are met, end the loop and print message
          MessageCli.PRINT_INFO_HAND.printMessage(player.getUsername(), option[0], option[1]);
          // Save the value of finger and sum to the player object
          player.setFingers(Integer.parseInt(option[0]));
          // Save the player fingers to the array list at index round
          player.setFingerArray(player.getFingers());
          player.setSum(Integer.parseInt(option[1]));
          conditions = 1;
        } else {
          // If conditions are not met, print error message and ask for input again
          MessageCli.INVALID_INPUT.printMessage();
          MessageCli.ASK_INPUT.printMessage();
          input = Utils.scanner.nextLine();
          option = input.split(" ");
        }
      } else {
        // If conditions are not met, print error message and ask for input again
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
        input = Utils.scanner.nextLine();
        option = input.split(" ");
      }
    }
    // Get the computers fingers and sum based off the difficulty level
    fingerComputer = difficultyLevel.fingers();
    sumComputer = difficultyLevel.sum();
    MessageCli.PRINT_INFO_HAND.printMessage(
        computer.getUsername(), Integer.toString(fingerComputer), Integer.toString(sumComputer));
    // Save the value of finger and sum to the computer object
    computer.setFingers(fingerComputer);
    computer.setSum(sumComputer);

    // Determines who wins or if there is a draw
    if ((player.getSum() == player.getFingers() + fingerComputer)
        && (computer.getSum() == player.getFingers() + fingerComputer)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      // If the computer wins, add 1 to the computer points and check if the computer has won
    } else if (computer.getSum() == player.getFingers() + fingerComputer) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      this.computer.setPoints(this.computer.getPoints() + 1);
      // If the computer has won, print the end game message and set started to 0
      if (this.computer.getPoints() == this.pointsToWin) {
        MessageCli.END_GAME.printMessage(computer.getUsername(), Integer.toString(round - 1));
        started = 0;
      }
      // If the player wins, add 1 to the player points and check if the player has won
    } else if (player.getSum() == player.getFingers() + fingerComputer) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      this.player.setPoints(this.player.getPoints() + 1);
      // If the player has won, print the end game message and set started to 0
      if (this.player.getPoints() == this.pointsToWin) {
        MessageCli.END_GAME.printMessage(player.getUsername(), Integer.toString(round - 1));
        started = 0;
      }
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void showStats() {
    // Check if the game has started, else print error message
    if (started != 1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // Print the stats of the player and computer
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        this.player.getUsername(),
        Integer.toString(this.player.getPoints()),
        Integer.toString(this.pointsToWin - this.player.getPoints()));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        this.computer.getUsername(),
        Integer.toString(this.computer.getPoints()),
        Integer.toString(this.pointsToWin - this.computer.getPoints()));
  }
}
