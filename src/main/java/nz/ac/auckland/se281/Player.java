package nz.ac.auckland.se281;

import java.util.ArrayList;

// Create a new parent class called Player with the following attributes: username, round, points
public class Player {

  private String username;
  private int points = 0;
  private int fingers;
  private int sum;

  private ArrayList<Integer> fingerArray = new ArrayList<Integer>();

  // Create a setter for fingerArray
  public void setFingerArray(int fingers) {
    fingerArray.add(fingers);
  }

  // Create a getter for fingerArray
  public ArrayList<Integer> getFingerArray() {
    return fingerArray;
  }

  // Create a setter for useraname
  public void setUsername(String username) {
    this.username = username;
  }

  // Create a getter for username
  public String getUsername() {
    return username;
  }

  // Create a setter for points
  public void setPoints(int points) {
    this.points = points;
  }

  // Create a getter for points
  public int getPoints() {
    return points;
  }

  // Create a setter for fingers
  public void setFingers(int fingers) {
    this.fingers = fingers;
  }

  // Create a getter for fingers
  public int getFingers() {
    return fingers;
  }

  // Create a setter for sum
  public void setSum(int sum) {
    this.sum = sum;
  }

  // Create a getter for sum
  public int getSum() {
    return sum;
  }
}
