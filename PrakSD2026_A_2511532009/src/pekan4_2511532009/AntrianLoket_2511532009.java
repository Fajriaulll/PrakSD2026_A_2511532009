package pekan4_2511532009;

public class AntrianLoket_2511532009 {
    private String[] data_2009;
    private int front_2009;
    private int rear_2009;
    private int kapasitas_2009;
    private int jumlah_2009;

    // Konstruktor
    public AntrianLoket_2511532009(int kapasitas_2009) {
        this.kapasitas_2009 = kapasitas_2009;
        this.data_2009 = new String[kapasitas_2009];
        this.front_2009 = 0;
        this.rear_2009 = -1;
        this.jumlah_2009 = 0;
    }

    // Mengecek apakah kosong
    public boolean kosong_2009() {
        return jumlah_2009 == 0;
    }

    // Mengecek apakah penuh
    public boolean penuh_2009() {
        return jumlah_2009 == kapasitas_2009;
    }

    // Tambah antrian
    public void tambah_2009(String nama_2009) {
        if (penuh_2009()) {
            System.out.println("Antrian penuh, tidak bisa menambah!");
            return;
        }
        rear_2009 = (rear_2009 + 1) % kapasitas_2009;
        data_2009[rear_2009] = nama_2009;
        jumlah_2009++;
        System.out.println(nama_2009 + " masuk ke antrian.");
    }

    // Hapus antrian
    public void hapus_2009() {
        if (kosong_2009()) {
            System.out.println("Antrian kosong, tidak ada yang dihapus!");
            return;
        }
        String keluar_2009 = data_2009[front_2009];
        front_2009 = (front_2009 + 1) % kapasitas_2009;
        jumlah_2009--;
        System.out.println(keluar_2009 + " telah dilayani.");
    }

    // Tampilkan isi antrian
    public void tampil_2009() {
        if (kosong_2009()) {
            System.out.println("Isi antrian: Kosong");
            return;
        }
        System.out.println("Isi antrian:");
        for (int i = 0; i < jumlah_2009; i++) {
            int idx = (front_2009 + i) % kapasitas_2009;
            System.out.println((i + 1) + ". " + data_2009[idx]);
        }
    }

    // Membalik isi antrian
    public void balik_2009() {
        if (kosong_2009()) {
            System.out.println("Antrian kosong, tidak bisa dibalik!");
            return;
        }
        String[] temp = new String[jumlah_2009];
        for (int i = 0; i < jumlah_2009; i++) {
            int idx = (front_2009 + i) % kapasitas_2009;
            temp[i] = data_2009[idx];
        }
        for (int i = 0; i < jumlah_2009; i++) {
            data_2009[i] = temp[jumlah_2009 - 1 - i];
        }
        front_2009 = 0;
        rear_2009 = jumlah_2009 - 1;
        System.out.println("Antrian berhasil dibalik.");
    }
}
