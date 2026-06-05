package pekan8_2511532009;

public class Lagu_2511532009 {
    // Atribut
    private String judul_2009;
    private String penyanyi_2009;
    private int durasi_2009;

    // Constructor
    public Lagu_2511532009(String judul_2009, String penyanyi_2009, int durasi_2009) {
        this.judul_2009 = judul_2009;
        this.penyanyi_2009 = penyanyi_2009;
        this.durasi_2009 = durasi_2009;
    }

    // Getter
    public String getJudul_2009() { return judul_2009; }
    public String getPenyanyi_2009() { return penyanyi_2009; }
    public int getDurasi_2009() { return durasi_2009; }

    // Setter
    public void setJudul_2009(String judul_2009) { this.judul_2009 = judul_2009; }
    public void setPenyanyi_2009(String penyanyi_2009) { this.penyanyi_2009 = penyanyi_2009; }
    public void setDurasi_2009(int durasi_2009) { this.durasi_2009 = durasi_2009; }

    // toString Override
    @Override
    public String toString() {
        return "Judul: " + judul_2009 + 
               " | Penyanyi: " + penyanyi_2009 + 
               " | Durasi: " + durasi_2009 + " detik";
    }
}
