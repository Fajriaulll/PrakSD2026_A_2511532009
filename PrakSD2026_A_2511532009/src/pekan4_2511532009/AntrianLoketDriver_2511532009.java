package pekan4_2511532009;

import java.util.Scanner;

public class AntrianLoketDriver_2511532009 {
    public static void main(String[] args) {
        Scanner input_2009 = new Scanner(System.in);
        AntrianLoket_2511532009 antrian_2009 = new AntrianLoket_2511532009(10);

        int pilihan;
        do {
            System.out.println("\n=== MENU ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Balikkan Antrian");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input_2009.nextInt();
            input_2009.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input_2009.nextLine();
                    antrian_2009.tambah_2009(nama);
                    break;
                case 2:
                    antrian_2009.hapus_2009();
                    break;
                case 3:
                    antrian_2009.tampil_2009();
                    break;
                case 4:
                    antrian_2009.balik_2009();
                    antrian_2009.tampil_2009();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        input_2009.close();
    }
}
