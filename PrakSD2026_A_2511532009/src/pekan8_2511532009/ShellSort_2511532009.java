package pekan8_2511532009;

public class ShellSort_2511532009 {

public static void shellSort_2511532009 (int[] A_2009) {
	int n_2009 = A_2009.length;
	int gap_2009 = n_2009 / 2;
	while (gap_2009 > 0) {
			for (int i_2009 = gap_2009; i_2009 < n_2009; i_2009++) {
				int temp_2009 = A_2009[i_2009];
				int j_2009 = i_2009;
				while (j_2009 >= gap_2009 && A_2009[j_2009 - gap_2009] > temp_2009) {
					A_2009[j_2009] = A_2009[j_2009 - gap_2009];
					j_2009 = j_2009 - gap_2009;
				}
				A_2009[j_2009] = temp_2009;
			}
			gap_2009 = gap_2009 / 2;
			}
		}

	public static void main (String[] args) {
		int[] data_2009 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		
		System.out.println("Sebelum : ");
		printArray(data_2009);
		
		shellSort_2511532009 (data_2009);
		
		System.out.println("Sesudah (Shell SOrt): ");
		printArray(data_2009);
	}
	
	public static void printArray (int [] arr) {
		for (int i : arr) System.out.println(i + " ");
		System.out.println();
	}
}