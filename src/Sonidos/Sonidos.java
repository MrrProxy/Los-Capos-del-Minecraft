package Sonidos;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonidos {

	protected Clip clips[];
	protected static Clip cerrarClip;
	private static Sonidos instanceSonidos;

	public static Sonidos getInstace() {
		if (instanceSonidos == null)
			instanceSonidos = new Sonidos();
		return instanceSonidos;
	}

	private Sonidos() {
		this.clips = new Clip[3];
	}

	public void crearSonidos() {
		for (int i = 1; i < clips.length; i++) {
			try {
				clips[i] = AudioSystem.getClip();
				InputStream audioSrc = getClass().getResourceAsStream("/zMusica/sound" + i + ".wav");
				InputStream bufferedIn = new BufferedInputStream(audioSrc);
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
				clips[i].open(inputStream);
			} catch (Exception e) {
			}
		}
	}

	public synchronized void playSound(int i) {
		clips[i].stop();
		clips[i].setFramePosition(0);
		clips[i].start();
	}

	public void playLoop(int i) {
		clips[i].stop();

		clips[i].loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopSound(int i) {
		if(clips[i].isRunning())
			clips[i].stop();
		else {
			clips[i].start();
		}
		
	}

	public void closeSound(int i) {
		clips[i].close();
	}

	public static synchronized void playSoundEffect(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream audioSrc = getClass().getResourceAsStream("/zMusica/" + url + ".wav");
					InputStream bufferedIn = new BufferedInputStream(audioSrc);
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();

	}
}