package FroggerGame.FroggerStart;

import FroggerGame.FroggerObjects.Actor;
import javafx.scene.image.Image;

public class End extends Actor {
	private boolean activated = false;

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}

	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(getClass().getResource("/Graphics/End.png").toExternalForm(), 60, 60, true, true));
	}

	public void setEnd() {
		setImage(new Image(getClass().getResource("/Graphics/FrogEnd.png").toExternalForm(), 70, 70, true, true));
		activated = true;
	}

	public boolean isActivated() {
		return activated;
	}
}
