package FroggerGame.FroggerObjects;

import java.util.ArrayList;
import FroggerGame.FroggerStart.End;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

/**
 * Represents the player-controlled frog in the Frogger game.
 * Handles movement, scoring, and interactions with obstacles, logs, and turtles.
 */
public class Animal extends Actor {
	private Image imgW1, imgA1, imgS1, imgD1;
	private Image imgW2, imgA2, imgS2, imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 26.6666666; // Movement speed
	private double movementX = 21.333333; // Horizontal movement speed
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean stop = false; // Game end flag
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<>();

	/**
	 * Constructs an {@code Animal} with the specified image.
	 * Initializes movement, image, and key event handlers.
	 *
	 * @param imageLink The URL of the frog's image.
	 */
	public Animal(String imageLink) {
		// Constructor implementation
	}

	/**
	 * Handles updates and interactions of the frog, including movement and collision checks.
	 *
	 * @param now The current timestamp.
	 */
	@Override
	public void act(long now) {
		// Method implementation
	}

	/**
	 * Ends the game and stops further movement.
	 */
	private void endGame() {
		// Method implementation
	}

	/**
	 * Notifies that the game has ended.
	 * Placeholder for notifying the game controller.
	 */
	private void notifyGameEnd() {
		// Method implementation
	}

	/**
	 * Checks if the game has stopped.
	 *
	 * @return {@code true} if the game has stopped, {@code false} otherwise.
	 */
	public boolean getStop() {
		return end >= 5 || stop;
	}

	/**
	 * Gets the current score of the frog.
	 *
	 * @return The score.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Checks if the score has changed.
	 *
	 * @return {@code true} if the score has changed, {@code false} otherwise.
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
}
