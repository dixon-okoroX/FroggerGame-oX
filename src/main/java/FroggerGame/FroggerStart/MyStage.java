package FroggerGame.FroggerStart;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyStage extends World {
	MediaPlayer mediaPlayer;

	@Override
	public void act(long now) {
		// No specific actions defined for the stage
	}

	public MyStage() {
		// Initialization logic if needed
	}

	public void playMusic() {
		try {
			// Assuming the media file is in the resources folder under p4_group_8_repo
			String musicFile = getClass().getResource("/p4_group_8_repo/Frogger Main Song Theme (loop).mp3").toExternalForm();
			Media sound = new Media(musicFile);
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		} catch (Exception e) {
			System.out.println("Error loading media file: " + e.getMessage());
		}
	}

	public void stopMusic() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
	}
}