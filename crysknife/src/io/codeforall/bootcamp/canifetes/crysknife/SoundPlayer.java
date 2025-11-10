package io.codeforall.bootcamp.canifetes.crysknife;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    public static void playSound(String filePath) {
        new Thread(() -> { // roda em paralelo, sem travar o jogo
            try {
                File soundFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

//                // Espera o som terminar antes de fechar
               Thread.sleep(clip.getMicrosecondLength() / 1000);
                clip.close();
                audioStream.close();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                System.err.println("Erro ao tocar som: " + e.getMessage());
            }
        }).start();
    }
}
