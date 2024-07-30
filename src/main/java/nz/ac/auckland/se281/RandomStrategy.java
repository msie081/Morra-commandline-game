package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int fingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int sum(int fingers) {
    return Utils.getRandomNumber(fingers + 1, fingers + 5);
  }
}
