package pekan6_2511532009;

public class Lagu_2511532009 {
    // mendefinisikan kelas node untuk lagu
    private String judul_2009;       // judul lagu
    private String penyanyi_2009;   // nama penyanyi
    private Lagu_2511532009 next_2009; // pointer ke node berikutnya
    private Lagu_2511532009 prev_2009; // pointer ke node sebelumnya

    // konstruktor
    public Lagu_2511532009(String judul_2009, String penyanyi_2009) {
        this.judul_2009 = judul_2009;
        this.penyanyi_2009 = penyanyi_2009;
        this.next_2009 = null;
        this.prev_2009 = null;
    }

    // Getter
    public String getJudul_2009() { return judul_2009; }
    public String getPenyanyi_2009() { return penyanyi_2009; }
    public Lagu_2511532009 getPrev_2009() { return prev_2009; }
    public Lagu_2511532009 getNext_2009() { return next_2009; }

    // Setter
    public void setJudul_2009(String judul_2009) { this.judul_2009 = judul_2009; }
    public void setPenyanyi_2009(String penyanyi_2009) { this.penyanyi_2009 = penyanyi_2009; }
    public void setPrev_2009(Lagu_2511532009 prev_2009) { this.prev_2009 = prev_2009; }
    public void setNext_2009(Lagu_2511532009 next_2009) { this.next_2009 = next_2009; }
}
