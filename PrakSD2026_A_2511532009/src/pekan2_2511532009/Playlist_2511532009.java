package pekan2_2511532009;
import java.util.*;

public class Playlist_2511532009 {
	
	// Menu
	public static void tampilkanMenu_2511532009() {
		System.out.println("\n\n- - Playlist Music NIM: 2511532009 - -");
		System.out.println("1. Tambah Lagu");
        System.out.println("2. Lihat Playlist");
        System.out.println("3. Hapus Lagu");
        System.out.println("4. Cek Kapasitas");
        System.out.println("5. Keluar");
	}
	
	// Tambah Lagu
	public static void tambahLagu_2511532009(ArrayList<Musik_2511532009> list_2009,Scanner sc) {
		System.out.print("Judul Lagu : ");
		String Judul_2009 = sc.nextLine();
		System.out.print("Nama Penyanyi : ");
		String Penyanyi_2009 = sc.nextLine();
		System.out.print("Durasi Lagu (detik) : ");
		int Durasi_2009 = sc.nextInt();
		sc.nextLine();
		if (Durasi_2009 <= 0 ) {
			System.out.println("Durasi harus lebih dari 0");
			return;
		}
		list_2009.add(new Musik_2511532009(Judul_2009, Penyanyi_2009, Durasi_2009));
		System.out.println("Data Berhasil ditambahkan");
		
		
	}
	//Melihat Playlist
	public static void lihatPlaylist_2511532009(ArrayList<Musik_2511532009> list_2009) {
		if(list_2009.isEmpty()) {
			System.out.println("Playlist Kosong. ");
		} else {
			System.out.println("Playlist : ");
			for (Musik_2511532009 musik_2009 : list_2009) {
				System.out.println(musik_2009);
			}
		}
	}
	
	//Hapus Lagu
	public static void hapusLagu_2511532009(ArrayList<Musik_2511532009> list_2009, Scanner sc) {
		System.out.print("Masukkan judul lagu yang ingin dihapus : ");
		String hapus_2009 = sc.nextLine();
		boolean removed_2009 = list_2009.removeIf(musik -> musik.getJudul_2511532009().equalsIgnoreCase(hapus_2009));
		
		if (removed_2009) {
			System.out.println("Lagu dengan judul " + hapus_2009 + " berhasil dihapus.");
		} else {
			System.out.println("Lagu tidak ditemukan");
		}
	}
	
	//Cek Kapasitas
	public static void cekKapasitas_2511532009(ArrayList<Musik_2511532009> list_2009) {
		System.out.println("Jumlah Lagu yang ada dalam playlist sekarang adalah : " + list_2009.size() + " Lagu." );
	}
	
	public static void main (String [] args) {
		ArrayList<Musik_2511532009> play_2009 = new ArrayList<>();
		Scanner scan_2009 = new Scanner (System.in);
		int pilih_2009;
		
		do {
			tampilkanMenu_2511532009();
			System.out.print("Pilih Menunya pruy : ");
			pilih_2009 = scan_2009.nextInt();
			scan_2009.nextLine();
			
			switch (pilih_2009) {
			case 1:
				tambahLagu_2511532009(play_2009, scan_2009);
				break;
			case 2:
				lihatPlaylist_2511532009(play_2009);
				break;
			case 3:
				hapusLagu_2511532009(play_2009, scan_2009);
				break;
			case 4:
				cekKapasitas_2511532009(play_2009);
				break;
			case 5:
				System.out.println("Keluar Dari Program. Sampai Jumpaa!!! ");
				break;
			default:
				System.out.println("Pilihan tidak valdi. ");
			}
		} while (pilih_2009 != 5);
		scan_2009.close();
	}
	
	

	

}
