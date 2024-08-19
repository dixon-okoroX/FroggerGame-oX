package FroggerGame.FroggerStart;

import FroggerGame.FroggerObjects.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage(getClass().getResource("iKogsKW.png").toExternalForm());

		background.add(froggerback);

		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 0, 166, 0.75));
		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 220, 166, 0.75));
		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 440, 166, 0.75));
		background.add(new Log(getClass().getResource("/LogImgs/logs.png").toExternalForm(), 300, 0, 276, -2));
		background.add(new Log(getClass().getResource("/LogImgs/logs.png").toExternalForm(), 300, 400, 276, -2));
		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 50, 329, 0.75));
		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 270, 329, 0.75));
		background.add(new Log(getClass().getResource("/LogImgs/log3.png").toExternalForm(), 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal(getClass().getResource("/FroggerImages/froggerUp.png").toExternalForm());
		background.add(animal);

		background.add(new Obstacle(getClass().getResource("/TruckImages/truck1Right.png").toExternalForm(), 0, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/TruckImages/truck1Right.png").toExternalForm(), 300, 649, 1, 120, 120));
		background.add(new Obstacle(getClass().getResource("/TruckImages/truck1Right.png").toExternalForm(), 600, 649, 1, 120, 120));

		background.add(new Obstacle(getClass().getResource("/CarImages/car1Left.png").toExternalForm(), 100, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/CarImages/car1Left.png").toExternalForm(), 250, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/CarImages/car1Left.png").toExternalForm(), 400, 597, -1, 50, 50));
		background.add(new Obstacle(getClass().getResource("/CarImages/car1Left.png").toExternalForm(), 550, 597, -1, 50, 50));

		background.add(new Obstacle(getClass().getResource("/TruckImages/truck2Right.png").toExternalForm(), 0, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/Truckimages/truck2Right.png").toExternalForm(), 500, 540, 1, 200, 200));
		background.add(new Obstacle(getClass().getResource("/CarImages/car1Left.png").toExternalForm(), 500, 490, -5, 50, 50));

		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
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
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
