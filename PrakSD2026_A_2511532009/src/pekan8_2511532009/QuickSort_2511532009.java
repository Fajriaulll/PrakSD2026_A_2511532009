package pekan8_2511532009;

public class QuickSort_2511532009 {
	static void swap_2511532009 (int[] arr_2009, int i_2009, int j_2009) 
	{
		int temp_2009 = arr_2009[i_2009];
		arr_2009[i_2009] = arr_2009[j_2009];
		arr_2009 [j_2009] = temp_2009;
	}
	// Metode tambahan untuk mengatur pivor menggunakan median of three
	static void medianOfThree_2511532009(int[] arr_2009, int low_2009, int high_2009)
	{
		int mid_2009 = low_2009 + (high_2009 - low_2009) / 2;
		
		// Urutkan elemen low, mid , dan high
		if (arr_2009[low_2009] > arr_2009[mid_2009]) {
			swap_2511532009(arr_2009, low_2009, mid_2009);
		}
		if (arr_2009[low_2009] > arr_2009[high_2009]) {
			swap_2511532009(arr_2009, low_2009, high_2009);
		}
		if (arr_2009[mid_2009] > arr_2009[high_2009]) {
			swap_2511532009(arr_2009, mid_2009, high_2009);
		}
		swap_2511532009(arr_2009, mid_2009, high_2009);
	}
	static int partition_2511532009 ( int [] arr_2009, int low_2009, int high_2009) 
	{
		// Panggil fungsi medianOfThree sebelum menentukan pivot
		medianOfThree_2511532009(arr_2009, low_2009, high_2009);
		
		int pivot_2009 = arr_2009[high_2009]; // Sekarang arr[high] sudah berisi nilai median
		int i_2009 = (low_2009-1);
		
		for (int j_2009 = low_2009; j_2009 <= high_2009 - 1; j_2009++) {
			// Jika elemen saat ini lebihkecil dari atau sama dengan pivor
			if (arr_2009[j_2009] < pivot_2009) {
				// Increment indeks elemen yang lebih kecil
				i_2009++;
				swap_2511532009(arr_2009, i_2009, j_2009);
			}
		}
			swap_2511532009(arr_2009, i_2009, 1);
			return (i_2009 + 1);
	}
	
	static void quickSort_2511532009 (int [] arr_2009, int low_2009, int high_2009)
	{
		if(low_2009 < high_2009) {
			int pi_2009 = partition_2511532009(arr_2009, low_2009, high_2009);
			quickSort_2511532009 (arr_2009, low_2009, pi_2009 - 1);
			quickSort_2511532009 (arr_2009, pi_2009 + 1, high_2009);
		}
	}
	
	public static void printArr_2511532009 (int [] arr_2009) 
	{
		for (int i_2009 = 0; i_2009 < arr_2009.length; i_2009++) {
			System.out.print(arr_2009[i_2009] + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) 
	{
		int [] arr_2009 = { 10, 7, 8, 9, 1, 5 };
		int N_2009 = arr_2009.length;
		System.out.print(" Data sebelum diurutkan: ");
		printArr_2511532009(arr_2009);
		
		quickSort_2511532009(arr_2009, 0, N_2009 - 1);
		
		System.out.print("Data Terurut quicsort: ");
		printArr_2511532009(arr_2009);
		
	}
}
