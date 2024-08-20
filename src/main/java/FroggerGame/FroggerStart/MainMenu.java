package FroggerGame.FroggerStart;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainMenu extends Scene {
    private Stage stage;

    public MainMenu(Stage stage) {
        super(new VBox(), 800, 600);
        this.stage = stage;

        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        // Set background image
        ImageView background = new ImageView(new Image(getClass().getResource("/Graphics/frog background.png").toExternalForm()));
        background.setFitWidth(800);
        background.setFitHeight(600);
        root.getChildren().add(background);

        // Title
        Text title = new Text("Frogger Game");
        title.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-fill: white;");
        root.getChildren().add(title);

        // Start Button
        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: green; -fx-text-fill: white;");
        startButton.setOnAction(e -> startGame());
        root.getChildren().add(startButton);

        // Options Button
        Button optionsButton = new Button("Options");
        optionsButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: yellow; -fx-text-fill: black;");
        optionsButton.setOnAction(e -> showOptions());
        root.getChildren().add(optionsButton);

        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 24px; -fx-padding: 10 20; -fx-background-color: red; -fx-text-fill: white;");
        exitButton.setOnAction(e -> exitGame());
        root.getChildren().add(exitButton);
    }

    private void startGame() {
        // Call the startGame method from Main class
        Main mainApp = new Main();
        mainApp.startGame(stage);  // This will now work because startGame is public
    }

    private void showOptions() {
        // Code to show options/settings
        System.out.println("Showing options...");
    }

    private void exitGame() {
        // Exit the application
        System.out.println("Exiting the game...");
        stage.close();
    }
}