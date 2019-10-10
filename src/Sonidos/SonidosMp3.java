package Sonidos;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class SonidosMp3 {
	private BasicPlayer player ;
	
	
	public SonidosMp3() {
		player = new BasicPlayer();

		
	}

	
	public void Play() throws Exception {
		  player.play();
	}
		 

	public void AbrirFichero( String url) {
		File fileNAct = new File(this.getClass().getResource("/zMusica/"+url+".mp3").getPath());
		try {
			player.open(fileNAct);
			player.play();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void Pausa() {
		try {
			if(player.getStatus() == BasicPlayer.PAUSED ) {
				player.resume();
			}
			else {
				player.pause();
			}
				
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void Continuar() throws Exception {
		player.resume();
	}

	public void Stop() throws Exception {
		player.stop();
	}
}
