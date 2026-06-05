package pekan8_2511532009;
import java.util.Scanner;

public class Sorting_2511532009 {

    private Lagu_2511532009[] dataLagu_2009;
    private int jumlahLagu_2009;

    public Sorting_2511532009() {
        dataLagu_2009 = new Lagu_2511532009[20];
        jumlahLagu_2009 = 0;
    }

    public void inputData_2009(Scanner scanner_2009) {
        while (true) {
            try {
                System.out.print("Masukkan jumlah lagu (min 7, maks 20): ");
                jumlahLagu_2009 = Integer.parseInt(scanner_2009.nextLine());

                if (jumlahLagu_2009 >= 7 && jumlahLagu_2009 <= 20) {
                    break;
                } else {
                    System.out.println("[Error] Jumlah lagu harus di antara 7 dan 20. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Input tidak valid! Harap masukkan angka bulat.");
            }
        }

        System.out.println("\nMasukkan data lagu:");
        for (int i_2009 = 0; i_2009 < jumlahLagu_2009; i_2009++) {
            System.out.println("Lagu ke-" + (i_2009 + 1) + ":");

            String judul_2009;
            while (true) {
                System.out.print("Judul    : ");
                judul_2009 = scanner_2009.nextLine().trim();
                if (!judul_2009.isEmpty()) break;
                System.out.println("[Error] Judul lagu tidak boleh kosong!");
            }

            String penyanyi_2009;
            while (true) {
                System.out.print("Penyanyi : ");
                penyanyi_2009 = scanner_2009.nextLine().trim();
                if (!penyanyi_2009.isEmpty()) break;
                System.out.println("[Error] Nama penyanyi tidak boleh kosong!");
            }

            int durasi_2009;
            while (true) {
                try {
                    System.out.print("Durasi (detik) : ");
                    durasi_2009 = Integer.parseInt(scanner_2009.nextLine());
                    if (durasi_2009 > 0) break;
                    System.out.println("[Error] Durasi harus lebih besar dari 0 detik!");
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Input tidak valid! Harap masukkan angka bulat untuk durasi.");
                }
            }

            dataLagu_2009[i_2009] = new Lagu_2511532009(judul_2009, penyanyi_2009, durasi_2009);
        }
    }

    public void shellSort_2009() {
        int n_2009 = jumlahLagu_2009;

        for (int gap_2009 = n_2009 / 2; gap_2009 > 0; gap_2009 /= 2) {
            for (int i_2009 = gap_2009; i_2009 < n_2009; i_2009++) {
                Lagu_2511532009 temp_2009 = dataLagu_2009[i_2009];
                int j_2009;

                for (j_2009 = i_2009; j_2009 >= gap_2009 && 
                     dataLagu_2009[j_2009 - gap_2009].getJudul_2009()
                     .compareToIgnoreCase(temp_2009.getJudul_2009()) > 0; 
                     j_2009 -= gap_2009) {
                    dataLagu_2009[j_2009] = dataLagu_2009[j_2009 - gap_2009];
                }

                dataLagu_2009[j_2009] = temp_2009;
            }
        }
    }

    public void tampilData_2009() {
        System.out.println();
        System.out.println("Data Sebelum Sorting:");
        for (int i_2009 = 0; i_2009 < jumlahLagu_2009; i_2009++) {
            System.out.println("\n" + dataLagu_2009[i_2009].getJudul_2009()
                    + " - " + dataLagu_2009[i_2009].getDurasi_2009() + " detik");
        }

        shellSort_2009();

        System.out.println();
        System.out.println("Data Setelah Shell Sort (Judul Asc):");
        for (int i_2009 = 0; i_2009 < jumlahLagu_2009; i_2009++) {
            System.out.println((i_2009 + 1) + ". " + dataLagu_2009[i_2009].getJudul_2009()
                    + " - " + dataLagu_2009[i_2009].getDurasi_2009() + " detik");
        }
    }

    public static void main(String[] args) {
        Scanner scanner_2009 = new Scanner(System.in);

        System.out.println("=== Sorting Playlist NIM : 2511532009 ===");
        System.out.println("Algoritma : Shell Sort (Ascending Judul)");

        Sorting_2511532009 playlist_2009 = new Sorting_2511532009();
        playlist_2009.inputData_2009(scanner_2009);
        playlist_2009.tampilData_2009();

        scanner_2009.close();
    }
}
