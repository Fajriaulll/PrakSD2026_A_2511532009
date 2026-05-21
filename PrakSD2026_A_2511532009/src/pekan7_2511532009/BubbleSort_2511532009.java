package pekan7_2511532009;

public class BubbleSort_2511532009 {
    public static void bubbleSort_2009(int[] arr_2009) {
        int n_2009 = arr_2009.length;
        for (int i_2009 = 0; i_2009 < n_2009; i_2009++) {
            for (int j_2009 = 0; j_2009 < n_2009 - i_2009 - 1; j_2009++) {
                if (arr_2009[j_2009] > arr_2009[j_2009 + 1]) {
                    int temp_2009 = arr_2009[j_2009];
                    arr_2009[j_2009] = arr_2009[j_2009 + 1];
                    arr_2009[j_2009 + 1] = temp_2009;
                    // System.out.println("data:" + arr_2009[j_2009] + " " + arr_2009[j_2009 + 1]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int arr_2009[] = { 23, 78, 45, 8, 32, 56, 1 };
        int n_2009 = arr_2009.length;
        System.out.print("array yang belum terurut: ");
        for (int i_2009 = 0; i_2009 < n_2009; i_2009++)
            System.out.print(arr_2009[i_2009] + " ");
        System.out.println("");
        
        bubbleSort_2009(arr_2009);
        
        System.out.print("array yang terurut menggunakan BubbleSort: ");
        for (int i_2009 = 0; i_2009 < n_2009; i_2009++)
            System.out.print(arr_2009[i_2009] + " ");
        System.out.println("");
    }
}
