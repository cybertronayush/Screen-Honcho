
package music;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;


public class MusicPlayer {
    Media media;
    MediaPlayer mediaPlayer;
    Status status;

    public static void main(String[] args) {
    }
    
    public void playNewMedia(String path) throws Exception {

        if (mediaPlayer != null) {
            status = mediaPlayer.getStatus();
            if (status == Status.PLAYING || status == Status.PAUSED || status == Status.READY) {
                mediaPlayer.stop();
            }
        }
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {
                mediaPlayer.play();
            }
        });
    }
    
    public void resumeOrPauseMedia() {
        if (mediaPlayer != null) {
            status = mediaPlayer.getStatus();
            if (status == Status.PLAYING) {
                mediaPlayer.pause();
            } else if (status == Status.PAUSED) {
                mediaPlayer.play();
            }
        }
    }

    public void slide(int d) {
        if (mediaPlayer != null) {
            mediaPlayer.seek(Duration.seconds(d));
        }
    }
    
    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
    
    public void setVolume(double value) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(value);
        }
    }
}
