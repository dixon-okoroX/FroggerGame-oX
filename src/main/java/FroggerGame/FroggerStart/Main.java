package FroggerGame.FroggerStart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import FroggerGame.FroggerObjects.Animal;
import FroggerGame.FroggerObjects.Obstacle;
import FroggerGame.FroggerObjects.WetTurtle;
import FroggerGame.FroggerObjects.Turtle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import FroggerGame.FroggerObjects.Log;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * The Main class serves as the entry point for the Frogger game.
 * It initializes the game, manages game stages, and handles high scores.
 * It also controls the game's main loop via an AnimationTimer.
 */
public class Main extends Application {

	/** The main game loop timer. */
	private AnimationTimer timer;

	/** The background stage for the game. */
	private MyStage background;

	/** The Animal (Frog) controlled by the player. */
	private Animal animal;

	/** The primary stage of the JavaFX application. */
	private Stage primaryStage;

	/** The main game scene. */
	private Scene gameScene;

	/** A list to store high scores. */
	private List<Integer> scores = new ArrayList<>();

	/**
	 * The main method that launches the JavaFX application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Starts the JavaFX application, initializes the main menu.
	 *
	 * @param primaryStage The primary stage of the application.
	 * @throws Exception if any error occurs during initialization.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Frogger Game");

		// Initialize and display the main menu.
		MainMenu mainMenu = new MainMenu(primaryStage, this);
		primaryStage.setScene(mainMenu);
		primaryStage.show();
	}

	/**
	 * Shows the main menu on the provided stage.
	 *
	 * @param stage The stage to display the main menu on.
	 */
	public void showMainMenu(Stage stage) {
		MainMenu mainMenu = new MainMenu(stage, this);
		stage.setScene(mainMenu);
		stage.show();
	}

	/**
	 * Starts the game by initializing game components and switching to the game scene.
	 *
	 * @param stage The stage to display the game on.
	 */
	public void startGame(Stage stage) {
		// Initialize game components
		background = new MyStage();
		gameScene = new Scene(background, 550, 800);

		BackgroundImage froggerback = new BackgroundImage(getClass().getResource("/Graphics/iKogsKW.png").toExternalForm());
		background.add(froggerback);

		// Add logs, turtles, wet turtles, end points, obstacles, etc.
		setupGameElements();

		animal = new Animal(getClass().getResource("/Graphics/FroggerImgs/froggerUp.png").toExternalForm());
		background.add(animal);

		// Start the background music and game loop
		background.start();
		this.primaryStage.setScene(gameScene);
		this.primaryStage.show();
		start();
	}

	/**
	 * Sets up the various game elements like logs, turtles, obstacles, and endpoints.
	 */
	private void setupGameElements() {
		// Add logs to the background
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 200, 0, 186, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 200, 220, 186, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 200, 440, 186, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/logs.png").toExternalForm(), 300, 0, 276, -2));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/logs.png").toExternalForm(), 300, 400, 276, -2));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 50, 365, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 270, 365, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 490, 365, 0.75));

		// Add turtles and wet turtles to the background
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));

		// Add end points to the background
		int startX = 13;
		int spacing = 141;
		int y = 96;
		for (int i = 0; i < 5; i++) {
			background.add(new End(startX + i * spacing, y));
		}

		// Add obstacles (trucks and cars) to the background
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 0, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 300, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 600, 649, 1, 120, 120));

		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 100, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 250, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 400, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 550, 597, -1, 50, 50));

		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck2Right.png").toExternalForm(), 0, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck2Right.png").toExternalForm(), 500, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 500, 490, -5, 50, 50));
	}

	/**
	 * Adds a score to the list of high scores and sorts them in descending order.
	 *
	 * @param score The score to be added to the high score list.
	 */
	public void addScore(int score) {
		scores.add(score);
		Collections.sort(scores, Collections.reverseOrder());
	}

	/**
	 * Retrieves the list of high scores.
	 *
	 * @return A list of high scores sorted in descending order.
	 */
	public List<Integer> getScores() {
		return scores;
	}

	/**
	 * Creates and initializes the AnimationTimer for the game loop.
	 * This method checks for score changes and game stop conditions.
	 */
	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					background.stopMusic();
					stop();
					background.stop();

					// Add the score to the list
					addScore(animal.getPoints());

					// Show High Score Popup
					showHighScorePopup();
				}
			}
		};
	}

	/**
	 * Displays a popup window showing the high scores at the end of a round.
	 */
	private void showHighScorePopup() {
		StringBuilder highScores = new StringBuilder();
		highScores.append("HIGH SCORES:\n\n");

		for (int i = 0; i < scores.size(); i++) {
			highScores.append((i + 1) + ". " + scores.get(i) + "\n");
		}

		// Display the high scores in an alert
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("High Scores");
		alert.setHeaderText("End of Round High Scores");
		alert.setContentText(highScores.toString());
		alert.show();
	}

	/**
	 * Starts the game loop and background music.
	 * If the AnimationTimer is not already created, it initializes it.
	 */
	public void start() {
		background.playMusic();
		if (timer == null) {
			createTimer();
		}
		timer.start();
	}

	/**
	 * Stops the game loop and any ongoing animations.
	 */
	public void stop() {
		if (timer != null) {
			timer.stop();
		}
	}

	/**
	 * Updates the on-screen score display with the provided number.
	 *
	 * @param n The number to display as the score.
	 */
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 30, 360 - shift, 25));
			shift += 30;
		}
	}
}
