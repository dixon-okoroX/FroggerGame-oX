package FroggerGame.FroggerStart;

import java.net.URL;  // Import URL class
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Scene {
    private Stage stage;
    private Main mainApp;  // Reference to the Main class instance

    public MainMenu(Stage stage, Main mainApp) {
        super(new BorderPane(), 600, 800);  // Adjusted dimensions to match the game
        this.stage = stage;
        this.mainApp = mainApp;

        // Root layout for the scene
        BorderPane root = (BorderPane) getRoot();

        // Validate and set background image
        URL imageUrl = getClass().getResource("/Graphics/iKogsKW.png");
        if (imageUrl == null) {
            System.err.println("Image not found!");
            root.setStyle("-fx-background-color: grey;");
        } else {
            Image backgroundImage = new Image(imageUrl.toExternalForm());
            ImageView background = new ImageView(backgroundImage);
            background.setFitWidth(600);
            background.setFitHeight(800);
            root.setCenter(background);
        }

        // Create VBox for menu items
        VBox menuBox = new VBox(20);  // 20px spacing between items
        menuBox.setAlignment(Pos.CENTER);

        // Title
        Text title = new Text("Frogger Game");
        title.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: white;");
        menuBox.getChildren().add(title);

        // Start Button
        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: green; -fx-text-fill: white;");
        startButton.setOnAction(e -> startGame());
        menuBox.getChildren().add(startButton);

        // Info Button
        Button infoButton = new Button("Info");
        infoButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: blue; -fx-text-fill: white;");
        infoButton.setOnAction(e -> showInfo());
        menuBox.getChildren().add(infoButton);

        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(e -> exitGame());
        menuBox.getChildren().add(exitButton);

        // Add menuBox to the center of the BorderPane
        root.setCenter(menuBox);
    }

    private void startGame() {
        // Use the existing Main instance to start the game
        mainApp.startGame(stage);
    }

    private void showInfo() {
        // Show game information in an alert dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Information");
        alert.setHeaderText("How to Play Frogger");
        alert.setContentText("Welcome to Frogger!\n\n"
                + "Controls:\n"
                + "  - Use the arrow keys to move the frog.\n"
                + "  - Move up to reach the goal areas at the top of the screen.\n"
                + "  - Avoid obstacles like cars and trucks.\n"
                + "  - Use logs and turtles to cross the rivers.\n\n"
                + "Objective:\n"
                + "  - Safely guide the frog to the top of the screen to score points.\n"
                + "  - Try to get the highest score possible!\n\n"
                + "Good luck and have fun!");
        alert.showAndWait();
    }

    private void exitGame() {
        // Exit the application
        System.out.println("Exiting the game...");
        stage.close();
    }
}
