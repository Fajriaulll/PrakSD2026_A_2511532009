package pekan8_2511532009;
public class MergeSort_2511532009 {
   static void merge_2009 (int [] arr_2009, int l_2009, int m_2009, int r_2009) {
        // find sizes of two subarrays to be merged
        int n1_2009 = m_2009 - l_2009 + 1;
        int n2_2009 = r_2009 - m_2009;
        /* create temp arrays */
        int L_2009 [] = new int [n1_2009];
        int R_2009 [] = new int [n2_2009];
        /*copy data to temp arrays */
        for (int i_2009 = 0; i_2009 < n1_2009; ++i_2009) 
            L_2009[i_2009] = arr_2009[l_2009+i_2009];
        for (int j_2009 = 0; j_2009 < n2_2009; ++j_2009)
            R_2009[j_2009] = arr_2009[m_2009 + 1 + j_2009];
        int i_2009 = 0, j_2009 = 0;
        //initial index merged subarray array
        int k_2009 = l_2009;
        while (i_2009 < n1_2009 && j_2009 < n2_2009) {
            if (L_2009[i_2009] <= R_2009[j_2009]) {
                arr_2009[k_2009] = L_2009[i_2009];
                i_2009++;
            } else {
                arr_2009[k_2009] = R_2009[j_2009];
                j_2009++;
            }
            k_2009++;
        }
        
        /* copy remaining elements of L [] if any */
        while (i_2009 < n1_2009) {
            arr_2009[k_2009] = L_2009[i_2009];
            i_2009++;
            k_2009++;
        }
        /* copy remaining elements of R [] if any */
        while (j_2009 < n2_2009) {
            arr_2009[k_2009] = R_2009[j_2009];
            j_2009++;
            k_2009++;
        }
    }
    
    void sort_2009 (int arr_2009[], int l_2009, int r_2009) {
        if (l_2009 < r_2009) {
            //find the middle point
            int m_2009 = (l_2009 + r_2009) / 2;
            //sort first and second halves
            sort_2009(arr_2009, l_2009, m_2009);
            sort_2009(arr_2009, m_2009 + 1, r_2009);
            //merge the sorted halves
            merge_2009(arr_2009, l_2009, m_2009, r_2009);
        }
    }
    
    /* a utility function to print array of size n */
    static void printArray_2009 (int arr_2009[]) {
        int n_2009 = arr_2009.length;
        for (int i_2009 = 0; i_2009 < n_2009; ++i_2009)
            System.out.print(arr_2009[i_2009] + " ");
        System.out.println();
    }
    
    public static void main (String args[]) {
        int arr_2009[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Sebelum terurut: ");
        printArray_2009(arr_2009);
        MergeSort_2511532009 ob_2009 = new MergeSort_2511532009();
        ob_2009.sort_2009(arr_2009, 0, arr_2009.length - 1);
        System.out.println("\nSesudah Terurut menggunakan merge sort");
        printArray_2009(arr_2009);
    }
}
