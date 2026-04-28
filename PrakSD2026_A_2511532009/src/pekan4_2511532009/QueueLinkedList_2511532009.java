package pekan4_2511532009;
import java.util.*;
import java.util.Queue;
public class QueueLinkedList_2511532009 {

	public static void main(String[] args) {
		Queue<Integer> q_2009 = new LinkedList<> ();
		// tambah elemen {0, 1, 2, 3, 4, 5} ke antrian
		for (int i_2009 = 0; i_2009 < 6; i_2009++)
			q_2009.add(i_2009);
		// Menampilkan isi antrian.
		System.out.println("Elemen Antrian " + q_2009);
		// Untuk menghapus kepala antrian.
		int hapus_2009 = q_2009.remove();
		System.out.println("Hapus elemen = " + hapus_2009);
		System.out.println(q_2009);
		// Untuk melihat antrian terdepan
		int depan_2009 = q_2009.peek();
		System.out.println("Kepala Antrian = " + depan_2009);
		
		int banyak_2009 = q_2009.size();
		System.out.println("Size Antrian = " + banyak_2009);
		
		
 
	}

}
