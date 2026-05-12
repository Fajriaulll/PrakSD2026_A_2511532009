package pekan6_2511532009;

public class PenelusuranDLL_2511532009 {
	// fungsi penelusuran maju
	static void forwardTraversal (NodeDLL_2511532009 head_2009) {
		// memulai penelususra dari head
		NodeDLL_2511532009 curr = head_2009;
		// lanjutkan sampai akhir
		while (curr != null) {
			// print data
			System.out.print(curr.data_2009 + " <-> ");
			// pindah ke node berikutnya
			curr = curr.next_2009;
		}
		// print spasi
		System.out.println();
	}
	// funsi penelusuran mundur
	static void backwardTransversal (NodeDLL_2511532009 tail_2009) {
		// mulai dari akhir
		NodeDLL_2511532009 curr = tail_2009;
		// lanjut sampai head
		while (curr != null) {
			// cetak data
			System.out.print(curr.data_2009 + " <-> ");
			// pindah ke node sebelumnya
			curr = curr.prev_2009;
		}
		// cetak spasi
		System.out.println();
	}
	public static void main (String[] args) {
		// cetak DLL
		NodeDLL_2511532009 head_2009 = new NodeDLL_2511532009(1);
		NodeDLL_2511532009 second_2009 = new NodeDLL_2511532009(2);
		NodeDLL_2511532009 third_2009 = new NodeDLL_2511532009(3);
		
		head_2009.next_2009 = second_2009;
		second_2009.prev_2009 = head_2009;
		second_2009.next_2009 = third_2009;
		third_2009.prev_2009 = second_2009;
		
		System.out.println("Penelusuran maju: ");
		forwardTraversal (head_2009);
		
		System.out.println("Penelusuran mundur: ");
		backwardTransversal(third_2009);
	}

}
