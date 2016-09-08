package sm.sound;

import javax.sound.sampled.LineListener;

/**
 *
 * @author Jesus Chamorro
 */
public interface SMPlayer {
    public void play();
    public void stop();

    public void setLineListener(LineListener lineListener);
}
