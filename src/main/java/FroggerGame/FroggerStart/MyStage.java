package FroggerGame.FroggerStart;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World {
	private MediaPlayer mediaPlayer;

	@Override
	public void act(long now) {
		// No specific actions defined for the stage
	}

	public MyStage() {
		// Initialization logic if needed
	}

	public void playMusic() {
		try {
			// Load the media file using getResource() and assuming the file is under /p4_group_8_repo
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