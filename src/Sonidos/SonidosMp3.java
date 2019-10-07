package Sonidos;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jlgui.basicplayer.BasicPlayer;

public class SonidosMp3 {
	private BasicPlayer player=new BasicPlayer(); ;
	
	
	public SonidosMp3() {
	}

	
	public void Play() throws Exception {
		  player.play();
	}
		 

	public void AbrirFichero( String url) throws Exception {
	//	File f = new File(getClass().getClassLoader().getResource("/zMusica/" + url + ".mp3").toURI());
		//FileInputStream fis = new FileInputStream(f);
		//InputStream audioSrc = getClass().getResourceAsStream("/zMusica/" + url + ".wav");
		//File fileNAct = new File(this.getClass().getResource("/zMusica/"+path+".mp3").getPath());
		//player.open(fis);
		//player.play();
	}

	public void Pausa() throws Exception {
		player.pause();
	}

	public void Continuar() throws Exception {
		player.resume();
	}

	public void Stop() throws Exception {
		player.stop();
	}
}
