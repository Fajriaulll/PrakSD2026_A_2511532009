package pekan2_2511532009;
import java.util.*;

public class Musik_2511532009 {
	
	//Atribut
	private String Judul_2009;
	private String Penyanyi_2009;
	private int Durasi_2009;

	// Konstruktor
	public Musik_2511532009(String Judul_2009, String Penyanyi_2009, int Durasi_2009) {
		this.Judul_2009=Judul_2009;
		this.Penyanyi_2009=Penyanyi_2009;
		this.Durasi_2009=Durasi_2009;
	}
	
	//Getter
	public String getJudul_2511532009() {
		return Judul_2009;
	}
	public String getPenyanyi_2511532009() {
		return Penyanyi_2009;
	}
	public int getDurasi_2511532009() {
		return Durasi_2009;
	}
	
	//Setter
	public void setJudul_2511532009(String Judul_2009) {
		this.Judul_2009=Judul_2009;
	}
	public void setPenyanyi_2511532009(String Penyanyi) {
		this.Penyanyi_2009=Penyanyi_2009;
	}
	public void setDurasi_2511532009(int Durasi_2009) {
		this.Durasi_2009 = Durasi_2009;
	}
	
	@Override
	public String toString () {
		return "\"" + Judul_2009 + "\" - " + Penyanyi_2009 + " (" + Durasi_2009 + " detik)";
	}

}
