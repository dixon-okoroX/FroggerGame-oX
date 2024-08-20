package FroggerGame.FroggerObjects;

import java.util.ArrayList;

import FroggerGame.FroggerStart.End;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Animal extends Actor {
	private Image imgW1, imgA1, imgS1, imgD1;
	private Image imgW2, imgA2, imgS2, imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 26.6666666; // 13.3333333 * 2
	private double movementX = 21.333333; // 10.666666 * 2
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean stop = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<>();

	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movement);

		// Load images using getClass().getResource()
		imgW1 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerUp.png").toExternalForm(), imgSize, imgSize, true, true);
		imgA1 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerLeft.png").toExternalForm(), imgSize, imgSize, true, true);
		imgS1 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerDown.png").toExternalForm(), imgSize, imgSize, true, true);
		imgD1 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerRight.png").toExternalForm(), imgSize, imgSize, true, true);
		imgW2 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerUpJump.png").toExternalForm(), imgSize, imgSize, true, true);
		imgA2 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerLeftJump.png").toExternalForm(), imgSize, imgSize, true, true);
		imgS2 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerDownJump.png").toExternalForm(), imgSize, imgSize, true, true);
		imgD2 = new Image(getClass().getResource("/Graphics/FroggerImgs/froggerRightJump.png").toExternalForm(), imgSize, imgSize, true, true);

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
					return;
				}
				if (second) {
					switch (event.getCode()) {
						case W:
							move(0, -movement);
							changeScore = false;
							setImage(imgW1);
							second = false;
							break;
						case A:
							move(-movementX, 0);
							setImage(imgA1);
							second = false;
							break;
						case S:
							move(0, movement);
							setImage(imgS1);
							second = false;
							break;
						case D:
							move(movementX, 0);
							setImage(imgD1);
							second = false;
							break;
						default:
							break;
					}
				} else {
					switch (event.getCode()) {
						case W:
							move(0, -movement);
							setImage(imgW2);
							second = true;
							break;
						case A:
							move(-movementX, 0);
							setImage(imgA2);
							second = true;
							break;
						case S:
							move(0, movement);
							setImage(imgS2);
							second = true;
							break;
						case D:
							move(movementX, 0);
							setImage(imgD2);
							second = true;
							break;
						default:
							break;
					}
				}
			}
		});

		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
					return;
				}
				switch (event.getCode()) {
					case W:
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points += 10;
						}
						move(0, -movement);
						setImage(imgW1);
						second = false;
						break;
					case A:
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
						break;
					case S:
						move(0, movement);
						setImage(imgS1);
						second = false;
						break;
					case D:
						move(movementX, 0);
						setImage(imgD1);
						second = false;
						break;
					default:
						break;
				}
			}
		});
	}

	@Override
	public void act(long now) {
		if (getY() < 0 || getY() > 734) {
			setX(300);
			setY(679.8 + movement);
		}
		if (getX() < 0) {
			move(movement * 2, 0);
		}
		if (carDeath) {
			noMove = true;
			if (now % 11 == 0) {
				carD++;
			}
			switch (carD) {
				case 1:
					setImage(new Image(getClass().getResource("/Graphics/CarImages/cardeath1.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 2:
					setImage(new Image(getClass().getResource("/Graphics/CarImages/cardeath2.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 3:
					setImage(new Image(getClass().getResource("/Graphics/CarImages/cardeath3.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 4:
					setX(300);
					setY(679.8 + movement);
					carDeath = false;
					carD = 0;
					setImage(new Image(getClass().getResource("/Graphics/FroggerImgs/froggerUp.png").toExternalForm(), imgSize, imgSize, true, true));
					noMove = false;
					if (points > 50) {
						points -= 50;
						changeScore = true;
					}
					break;
				default:
					break;
			}
		}
		if (waterDeath) {
			noMove = true;
			if (now % 11 == 0) {
				carD++;
			}
			switch (carD) {
				case 1:
					setImage(new Image(getClass().getResource("/Graphics/waterdeath1.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 2:
					setImage(new Image(getClass().getResource("/Graphics/waterdeath2.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 3:
					setImage(new Image(getClass().getResource("/Graphics/waterdeath3.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 4:
					setImage(new Image(getClass().getResource("/Graphics/waterdeath4.png").toExternalForm(), imgSize, imgSize, true, true));
					break;
				case 5:
					setX(300);
					setY(679.8 + movement);
					waterDeath = false;
					carD = 0;
					setImage(new Image(getClass().getResource("/Graphics/FroggerImgs/froggerUp.png").toExternalForm(), imgSize, imgSize, true, true));
					noMove = false;
					if (points > 50) {
						points -= 50;
						changeScore = true;
					}
					break;
				default:
					break;
			}
		}

		if (getX() > 600) {
			move(-movement * 2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Log.class).get(0).getLeft()) {
				move(-2, 0);
			} else {
				move(0.75, 0);
			}
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (inter.get(0).isActivated()) {
				end--;
				points -= 50;
				changeScore = true;
				w = 800;
				inter.get(0).setEnd();
				end++;
				setX(300);
				setY(679.8 + movement);
			}
		} else if (getY() < 413) {
			waterDeath = true;
		}
	}

	public boolean getStop() {
		return end == 5;
	}

	public int getPoints() {
		return points;
	}

	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
}