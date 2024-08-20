package FroggerGame.FroggerStart;

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

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal;
	private Stage primaryStage;  // This is now initialized in the start method.
	private Scene gameScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;  // Assign the primaryStage here.
		primaryStage.setTitle("Frogger Game");

		// Pass both the primaryStage and this instance of Main
		MainMenu mainMenu = new MainMenu(primaryStage, this);
		primaryStage.setScene(mainMenu);
		primaryStage.show();
	}


	public void showMainMenu(Stage stage) {
		MainMenu mainMenu = new MainMenu(stage,this);
		stage.setScene(mainMenu);
		stage.show();
	}

	public void startGame(Stage stage) {
		// Initialize game components
		background = new MyStage();
		gameScene = new Scene(background, 600, 800);

		BackgroundImage froggerback = new BackgroundImage(getClass().getResource("/Graphics/iKogsKW.png").toExternalForm());
		background.add(froggerback);

		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 0, 166, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 220, 166, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 440, 166, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/logs.png").toExternalForm(), 300, 0, 276, -2));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/logs.png").toExternalForm(), 300, 400, 276, -2));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 50, 329, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 270, 329, 0.75));
		background.add(new Log(getClass().getResource("/Graphics/LogImgs/log3.png").toExternalForm(), 150, 490, 329, 0.75));

		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));

		background.add(new End(13, 96));
		background.add(new End(141, 96));
		background.add(new End(141 + 141 - 13, 96));
		background.add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
		background.add(new End(141 + 141 - 13 + 141 - 13 + 141 - 13 + 3, 96));

		animal = new Animal(getClass().getResource("/Graphics/FroggerImgs/froggerUp.png").toExternalForm());
		background.add(animal);

		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 0, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 300, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck1Right.png").toExternalForm(), 600, 649, 1, 120, 120));

		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 100, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 250, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 400, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 550, 597, -1, 50, 50));

		background.add(new Obstacle(getClass().getResource("/Graphics/TruckImages/truck2Right.png").toExternalForm(), 0, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/Graphics/Truckimages/truck2Right.png").toExternalForm(), 500, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/Graphics/CarImages/car1Left.png").toExternalForm(), 500, 490, -5, 50, 50));

		background.start();
		this.primaryStage.setScene(gameScene);  // Use the primaryStage here.
		this.primaryStage.show();
		start();
	}

	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					System.out.print("STOPP:");
					background.stopMusic();
					stop();
					background.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();
				}
			}
		};
	}

	public void start() {
		background.playMusic();
		if (timer == null) {
			createTimer();
		}
		timer.start();
	}

	public void stop() {
		if (timer != null) {
			timer.stop();
		}
	}

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