# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)
# Frogger Game
# Overview
Frogger Game is a JavaFX-based implementation of the classic arcade game Frogger. In this game, the player controls a frog and must navigate it across roads and rivers while avoiding obstacles and reaching designated goal areas. The game involves moving the frog up the screen, dodging cars, and using logs and turtles to cross the water.

# Features
- Player Control: Move the frog using arrow keys.
-  Obstacles: Avoid cars and trucks on the road.
- Water Navigation: Use logs and turtles to cross rivers.
- Scoring: Earn points by reaching goal areas and avoid losing points when hit by obstacles.
- Game States: Includes game start, in-progress, and end states.
# Requirements
Java Development Kit (JDK): Version 11 or higher.
JavaFX: Ensure JavaFX SDK is properly set up with your JDK.
Installation
Clone the Repository

# Installation
Clone the repository code 
- git clone https://github.com/your-username/frogger-game.git
- Navigate to Project Directory

Navigate to Project Directory

- cd frogger-game

Compile the Project
- Compile using 
- javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out src/**/*.java

Run the Project
- java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out FroggerGame.FroggerStart.Main



# Usage
Starting the Game:

Launch the game using the provided instructions.
The main menu will display options to start the game, view information, or exit.

In-Game Controls:

- W: Move up
- A: Move left
- S: Move down
- D: Move right

Game Objectives:

- Guide the frog to the top of the screen to score points.
- Avoid cars and trucks to prevent losing the game.
- Use logs and turtles to cross the water safely.
- Reach goal areas for additional points.

# Project Structure
src/: Contains the source code of the game.

- FroggerGame/FroggerStart/Main.java: Entry point for the application.
- FroggerGame/FroggerStart/MainMenu.java: Main menu implementation.
- FroggerGame/FroggerObjects/Animal.java: Player-controlled frog implementation.
- Other classes for game objects and logic.



# License
This project is licensed under the MIT License. See the LICENSE file for details.

# Acknowledgements
Thanks to the creators of the original Frogger game.
JavaFX and its documentation were crucial for implementing the graphical user interface.