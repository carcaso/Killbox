package org.academiadecodigo.secondrow.killbox.objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    private Clip clip;

    public void playSound(int count, String pathname) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(pathname).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(count);

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

}
