package pekan6_2511532009;

import java.util.Scanner;

public class Musik_2511532009 {
    static Scanner scanner_2009 = new Scanner(System.in); // scanner untuk input pengguna
    
    public static Lagu_2511532009 tambahLagu_2009(Lagu_2511532009 head_2009, String judul_2009, String penyanyi_2009) {
        Lagu_2511532009 laguBaru_2009 = new Lagu_2511532009(judul_2009, penyanyi_2009); // buat node lagu baru
        if (head_2009 == null) {
            head_2009 = laguBaru_2009; // jika kosong, jadi head
        } else {
            Lagu_2511532009 curr_2009 = head_2009;
            while (curr_2009.getNext_2009() != null) {
                curr_2009 = curr_2009.getNext_2009();
            }
            curr_2009.setNext_2009(laguBaru_2009);
            laguBaru_2009.setPrev_2009(curr_2009);
        }
        return head_2009; // kembalikan head yang sudah diupdate
    }
    
    public static Lagu_2511532009 hapusLaguAwal_2009(Lagu_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Playlist kosong!");
            return null;
        }
        System.out.println("Lagu \"" + head_2009.getJudul_2009() + "\" dihapus!");
        if (head_2009.getNext_2009() != null) {
            head_2009 = head_2009.getNext_2009();
            head_2009.setPrev_2009(null);
        } else {
            head_2009 = null;
        }
        return head_2009;
    }
    
    public static void tampilMaju_2009(Lagu_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        System.out.println("\n=== Playlist (Maju) ===");
        Lagu_2511532009 curr_2009 = head_2009;
        int nomor_2009 = 1;
        while (curr_2009 != null) {
            System.out.println(nomor_2009 + ". " + curr_2009.getJudul_2009() + " - " + curr_2009.getPenyanyi_2009());
            curr_2009 = curr_2009.getNext_2009();
            nomor_2009++;
        }
        System.out.println("=======================");
    }
    
    public static void tampilMundur_2009(Lagu_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511532009 curr_2009 = head_2009;
        while (curr_2009.getNext_2009() != null) {
            curr_2009 = curr_2009.getNext_2009();
        }
        System.out.println("\n=== Playlist (Mundur) ===");
        int nomor_2009 = 1;
        while (curr_2009 != null) {
            System.out.println(nomor_2009 + ". " + curr_2009.getJudul_2009() + " - " + curr_2009.getPenyanyi_2009());
            curr_2009 = curr_2009.getPrev_2009();
            nomor_2009++;
        }
        System.out.println("========================");
    }
    
    public static void cariLagu_2009(Lagu_2511532009 head_2009, String judul_2009) {
        if (head_2009 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511532009 curr_2009 = head_2009;
        boolean ditemukan_2009 = false;
        while (curr_2009 != null) {
            if (curr_2009.getJudul_2009().equalsIgnoreCase(judul_2009)) {
                System.out.println("Ditemukan: " + curr_2009.getJudul_2009() + " - " + curr_2009.getPenyanyi_2009());
                ditemukan_2009 = true;
                break;
            }
            curr_2009 = curr_2009.getNext_2009();
        }
        if (!ditemukan_2009) {
            System.out.println("Lagu \"" + judul_2009 + "\" tidak ditemukan.");
        }
    }
    
    public static void tampilkanMenu_2009() {
        Lagu_2511532009 head_2009 = null;
        int pilihan_2009;
        do {
            System.out.print("\n=== Playlist Musik NIM: 2511532009 ===\n"
                    + "1. Tambah Lagu\n2. Hapus Lagu Pertama\n3. Lihat Playlist (Maju)\n"
                    + "4. Lihat Playlist (Mundur)\n5. Cari Lagu\n6. Keluar\nPilihan: ");
            pilihan_2009 = scanner_2009.nextInt();
            scanner_2009.nextLine();
            switch (pilihan_2009) {
                case 1:
                    System.out.print("Judul: ");
                    String judul_2009 = scanner_2009.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi_2009 = scanner_2009.nextLine();
                    head_2009 = tambahLagu_2009(head_2009, judul_2009, penyanyi_2009);
                    System.out.println("Lagu berhasil ditambahkan!");
                    break;
                case 2:
                    head_2009 = hapusLaguAwal_2009(head_2009);
                    break;
                case 3:
                    tampilMaju_2009(head_2009);
                    break;
                case 4:
                    tampilMundur_2009(head_2009);
                    break;
                case 5:
                    System.out.print("Cari judul: ");
                    String cari_2009 = scanner_2009.nextLine();
                    cariLagu_2009(head_2009, cari_2009);
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan_2009 != 6);
        scanner_2009.close();
    }
    
    public static void main(String[] args) {
        tampilkanMenu_2009();
    }
}
