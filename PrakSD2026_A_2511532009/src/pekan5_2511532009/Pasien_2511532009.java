package pekan5_2511532009; // Package untuk mengelompokkan kelas sesuai NIM

// Kelas ADT Pasien yang merepresentasikan node dalam Single Linked List
public class Pasien_2511532009 {
    // Atribut data pasien dan pointer next dengan suffix NIM
    private String nama_2009;
    private String penyakit_2009;
    private int no_2009;
    private Pasien_2511532009 next_2009;
    
    // Constructor untuk menginisialisasi data pasien saat node dibuat
    public Pasien_2511532009(String nama_2009, String penyakit_2009, int no_2009) {
        this.nama_2009 = nama_2009;
        this.penyakit_2009 = penyakit_2009;
        this.no_2009 = no_2009;
        this.next_2009 = null;
    }
    
    // Getter: mengambil nilai atribut
    public String getNama_2009() { return nama_2009; }
    public String getPenyakit_2009() { return penyakit_2009; }
    public int getNomor_2009() { return no_2009; }
    public Pasien_2511532009 getNext() { return next_2009; }
    
    // Setter: mengubah nilai atribut atau menghubungkan pointer next
    public void setNama_2009(String nama_2009) { this.nama_2009 = nama_2009; }
    public void setPenyakit_2009(String penyakit_2009) { this.penyakit_2009 = penyakit_2009; }
    public void setNomor_2009(int no_2009) { this.no_2009 = no_2009; }
    public void setNext_2009(Pasien_2511532009 next_2009) { this.next_2009 = next_2009; }
}
