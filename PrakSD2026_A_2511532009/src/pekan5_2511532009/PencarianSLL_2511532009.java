package pekan5_2511532009;

public class PencarianSLL_2511532009 {
    static boolean searchKey_2009(NodeSLL_2511532009 head_2009, int key_2009) {
        NodeSLL_2511532009 curr_2009 = head_2009;
        while (curr_2009 != null) {
            if (curr_2009.data_2009 == key_2009) 
                return true;
            curr_2009 = curr_2009.next_2009;
        }
        return false;
    }

    public static void traversal_2009(NodeSLL_2511532009 head_2009) {
    	// mulai dari head
        NodeSLL_2511532009 curr_2009 = head_2009;
        // telusuri sampai pointer null
        while (curr_2009 != null) {
            System.out.print(" " + curr_2009.data_2009);
            curr_2009 = curr_2009.next_2009;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeSLL_2511532009 head_2009 = new NodeSLL_2511532009(14);
        head_2009.next_2009 = new NodeSLL_2511532009(21);
        head_2009.next_2009.next_2009 = new NodeSLL_2511532009(13);
        head_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(30);
        head_2009.next_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(10);
        System.out.print("Penelusuran SLL :");
        traversal_2009(head_2009);
        // data yang akan dicari
        int key_2009 = 30;
        System.out.print("cari data " + key_2009 + " = ");
        if (searchKey_2009(head_2009, key_2009))
            System.out.println("Ketemu");
        else
            System.out.println("tidak ada");
    }
}
