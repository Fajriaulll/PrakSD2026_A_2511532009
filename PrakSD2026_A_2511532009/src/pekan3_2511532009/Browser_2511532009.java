package pekan3_2511532009;
import java.util.*;

public class Browser_2511532009 {
	
	//menu
	// Menampilkan bagian menu dari program ini
	public static void tampilkanMenu_2511532009 () {
		System.out.println("\n\n--- Browser History NIM : 2511532009 ---");
		System.out.println("1. Kunjungi Website (push)");
		System.out.println("2. Tombol Back (pop)");
		System.out.println("3. Lihat Halaman Aktif (peek)");
		System.out.println("4. Cek Status History");
		System.out.println("5. Keluar");
	}
	
	//push
	//Mengunjungi website
	public static void push_2511532009 (Stack<Website_2511532009> stack, Scanner sc) {
		System.out.print("Masukkan Nama Website: ");
		String judul_2009 = sc.nextLine();
		System.out.print("Masukkan URL: ");
		String link_2009 = sc.nextLine();
		stack.push(new Website_2511532009(judul_2009, link_2009));
		System.out.println("Berhasil mengunjungi Website");
	}
	
	//pop
	// Tombol Back
	public static void pop_2511532009 (Stack<Website_2511532009> stack_2009) {
		if (stack_2009.isEmpty()) {
			System.out.println("Tidak ada riwayat. Sudah di Halaman awal");
		} else {
			Website_2511532009 back = stack_2009.pop();
			System.out.println("Keluar dari: " + back.getJudul_2009());
			
			if (!stack_2009.isEmpty()) {
				System.out.println("Kembali ke : " + stack_2009.peek().getJudul_2009());
			} else {
				System.out.println("Tidak ada halaman sebelumnya.");
			}
		}
	}
	
	//peek
	//Melihat halaman mana yang aktif
	public static void peek_2511532009 (Stack<Website_2511532009> stack_2009) {
		if (stack_2009.isEmpty()) {
			System.out.println("Tidak ada halaman yang aktif.");
		} else {
			Website_2511532009 aktif = stack_2009.peek();
			System.out.println("\n-- Halaman Aktif --");
			System.out.println("Judul : " + aktif.getJudul_2009());
			System.out.println("URL : " + aktif.getLink_2009());
			
		}
	}
	
	//status history
	public static void status_2511532009 (Stack<Website_2511532009> stack_2009) {
		if (stack_2009.isEmpty()) {
			System.out.println("Belum ada halaman yang dikunjungi");
		} else {
			System.out.println("History Tidak Kosong");
			System.out.println("Terdapat total riwayat " + stack_2009.size() + " Halaman");
			System.out.println("Daftar Riwayat ( Pertama ke terakhir ) ");
			for (int i = 0; i < stack_2009.size(); i++) {
				String tanda_2009 = (i == stack_2009.size() -1) ? " <- Aktif" : "";
				System.out.println(" " + (i+1) + ". " + stack_2009.get(i).toString()+ tanda_2009);
			}
		}
	}
	
	// Loop Utama
	public static void main (String [] args) {
		Stack<Website_2511532009> gas_2009 = new Stack<>();
		Scanner scan_2009 = new Scanner (System.in);
		int pilih_2009;
		
		do {
			tampilkanMenu_2511532009();
			System.out.print("Pilihan : ");
			pilih_2009 = scan_2009.nextInt();
			scan_2009.nextLine();
			
			switch (pilih_2009) {
			case 1:
				push_2511532009 (gas_2009, scan_2009);
				break;
			case 2:
				pop_2511532009 (gas_2009);
				break;
			case 3:
				peek_2511532009 (gas_2009);
				break;
			case 4:
				status_2511532009 (gas_2009);
				break;
			case 5:
				System.out.println("Sekian TerimaKasih");
				break;
			default:
				System.out.println("Angka Tidak Valid");
			}	
		} while (pilih_2009 != 5);
		scan_2009.close();
	}
	

}
