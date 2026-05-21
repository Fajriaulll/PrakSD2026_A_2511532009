package pekan7_2511532009;

// Kelas ADT untuk menyimpan data mahasiswa
public class Mahasiswa_2511532009 {

    // Atribut data mahasiswa
    private String nama_2009;
    private String nim_2009;
    private String prodi_2009;

    // Constructor
    public Mahasiswa_2511532009(String nama_2009, String nim_2009, String prodi_2009) {
        this.nama_2009 = nama_2009;
        this.nim_2009 = nim_2009;
        this.prodi_2009 = prodi_2009;
    }

    // Getter dan Setter
    public String getNama_2009() {
        return nama_2009;
    }

    public void setNama_2009(String nama_2009) {
        this.nama_2009 = nama_2009;
    }

    public String getNim_2009() {
        return nim_2009;
    }

    public void setNim_2009(String nim_2009) {
        this.nim_2009 = nim_2009;
    }

    public String getProdi_2009() {
        return prodi_2009;
    }

    public void setProdi_2009(String prodi_2009) {
        this.prodi_2009 = prodi_2009;
    }

    // toString untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return nama_2009 + " | " + nim_2009 + " | " + prodi_2009;
    }
}