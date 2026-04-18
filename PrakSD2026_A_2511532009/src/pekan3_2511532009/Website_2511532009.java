package pekan3_2511532009;
import java.util.*;

public class Website_2511532009 {
	
	//atribute
	private String judul_2009;
	private String link_2009;
	
	//konstruktor
	public Website_2511532009 (String judul_2009, String link_2009) {
		this.judul_2009 = judul_2009;
		this.link_2009 = link_2009;
	}
	
	//getter
	public String getJudul_2009() {
		return judul_2009;
	}
	public String getLink_2009() {
		return link_2009;
	}
	
	//setter
	public void setJudul_2009 (String judul) {
		this.judul_2009=judul_2009;
	}
	public void setLink_2009 (String link) {
		this.link_2009=link_2009;
	}
	
	@Override 
	public String toString () {
		return "Judul " + judul_2009 + " | " + link_2009;
	}

}
