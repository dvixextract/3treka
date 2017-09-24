/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

    import javafx.animation.Animation;
    import javafx.animation.KeyFrame;
    import javafx.animation.Timeline;
    import javafx.util.Duration;

/**
 *
 * @author User
 */
public class StopWatch extends DefaultLabel {
	
    private int max;
    private int seconds;
    private Timeline timeline;

    public StopWatch(int maxSeconds) {
        super(128);
        seconds = max = maxSeconds;
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
            seconds--;
            updateText();
            if(seconds <= 0) {
                stop();
                onComplete();
            }
        }));
        updateText();
        start();
    }

    protected void onComplete() {}

    private void updateText() {
        setText(String.format("%d:%02d", seconds/60, seconds%60));
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public void reset() {
        seconds = max;
    }
}
