package pekan5_2511532009;

import java.util.Scanner;

public class RumahSakit_2511532009 {
    
    
    static int counterAntrian_2009 = 0;

    public static Pasien_2511532009 insertAtTail_2009(Pasien_2511532009 head_2009, String nama_2009, String penyakit_2009) {
        counterAntrian_2009++;
        Pasien_2511532009 newNode_2009 = new Pasien_2511532009(nama_2009, penyakit_2009, counterAntrian_2009);
        
        if (head_2009 == null) {
            return newNode_2009;
        }
        
        Pasien_2511532009 last_2009 = head_2009;
        while (last_2009.getNext() != null) {
            last_2009 = last_2009.getNext();
        }
        
        last_2009.setNext_2009(newNode_2009);
        return head_2009;
    }

    // Delete Head: menghapus pasien terdepan dan menggeser head ke simpul berikutnya
    public static Pasien_2511532009 deleteHead_2009(Pasien_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Antrian kosong! Tidak ada pasien yang bisa dipanggil.");
            return null;
        }
        
        Pasien_2511532009 pasienDipanggil_2009 = head_2009;
        System.out.println("\n=== Pasien Dipanggil ===");
        System.out.println("Nama          : " + pasienDipanggil_2009.getNama_2009());
        System.out.println("Penyakit      : " + pasienDipanggil_2009.getPenyakit_2009());
        System.out.println("Nomor Antrian : " + pasienDipanggil_2009.getNomor_2009());
        
        return head_2009.getNext();
    }

    // Display List: menampilkan seluruh data pasien dalam antrian
    public static void printList_2009(Pasien_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Antrian kosong. Belum ada pasien terdaftar.");
            return;
        }
        
        System.out.println("\n=== Daftar Antrian ===");
        Pasien_2511532009 curr_2009 = head_2009;
        
        while (curr_2009 != null) {
            System.out.println("[" + curr_2009.getNomor_2009() + "] " + 
                               curr_2009.getNama_2009() + " - " + 
                               curr_2009.getPenyakit_2009() + 
                               (curr_2009.getNext() != null ? " -->" : ""));
            curr_2009 = curr_2009.getNext();
        }
    }

    // Search Case-Insensitive: mencari pasien berdasarkan nama
    public static void searchPatient_2009(Pasien_2511532009 head_2009, String namaCari_2009) {
        if (head_2009 == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        
        Pasien_2511532009 curr_2009 = head_2009;
        boolean ditemukan_2009 = false;
        
        while (curr_2009 != null) {
            if (curr_2009.getNama_2009().equalsIgnoreCase(namaCari_2009)) {
                System.out.println("\n=== Pasien Ditemukan ===");
                System.out.println("Nama          : " + curr_2009.getNama_2009());
                System.out.println("Penyakit      : " + curr_2009.getPenyakit_2009());
                System.out.println("Nomor Antrian : " + curr_2009.getNomor_2009());
                ditemukan_2009 = true;
                break;
            }
            curr_2009 = curr_2009.getNext();
        }
        
        if (!ditemukan_2009) {
            System.out.println("Pasien dengan nama '" + namaCari_2009 + "' tidak ditemukan.");
        }
    }

    // Cek Status Antrian: menghitung total pasien dan menampilkan pasien terdepan
    public static void checkStatus_2009(Pasien_2511532009 head_2009) {
        if (head_2009 == null) {
            System.out.println("Status Antrian: KOSONG. Tidak ada pasien.");
            return;
        }
        
        int total_2009 = 0;
        Pasien_2511532009 curr_2009 = head_2009;
        while (curr_2009 != null) {
            total_2009++;
            curr_2009 = curr_2009.getNext();
        }
        
        System.out.println("\n=== Status Antrian ===");
        System.out.println("Total Pasien    : " + total_2009);
        System.out.println("Pasien Terdepan : " + head_2009.getNama_2009() + 
                           " (No. " + head_2009.getNomor_2009() + ")");
    }

    // Menu utama
    public static void main(String[] args) {
        Scanner input_2009 = new Scanner(System.in);
        Pasien_2511532009 head_2009 = null;
        int pilihan_2009 = 0;

        do {
            System.out.println("\n=== Antrian Rumah Sakit NIM: 2511532009 ===");
            System.out.println("1. Daftarkan Pasien (Insert at Tail)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            if (input_2009.hasNextInt()) {
                pilihan_2009 = input_2009.nextInt();
                input_2009.nextLine();
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka 1-6.");
                input_2009.nextLine();
                continue;
            }

            switch (pilihan_2009) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama_2009 = input_2009.nextLine();
                    System.out.print("Masukkan Penyakit   : ");
                    String penyakit_2009 = input_2009.nextLine();
                    head_2009 = insertAtTail_2009(head_2009, nama_2009, penyakit_2009);
                    System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counterAntrian_2009);
                    break;
                case 2:
                    head_2009 = deleteHead_2009(head_2009);
                    break;
                case 3:
                    printList_2009(head_2009);
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari_2009 = input_2009.nextLine();
                    searchPatient_2009(head_2009, cari_2009);
                    break;
                case 5:
                    checkStatus_2009(head_2009);
                    break;
                case 6:
                    System.out.println("Program selesai. Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
            }
        } while (pilihan_2009 != 6);

        input_2009.close();
    }
}
