package pekan6_2511532009;
public class HapusDLL_2511532009 {
    //fungsi menghapus node awal
    public static NodeDLL_2511532009 delHead_2009 (NodeDLL_2511532009 head_2009) {
        if (head_2009 == null) {
            return null;
        }
        NodeDLL_2511532009 temp_2009 = head_2009;
        head_2009 = head_2009.next_2009;
        if (head_2009 != null) {
            head_2009.prev_2009 = null;
        }
        return head_2009;
    }
    //fungsi menghapus di akhir 
    public static NodeDLL_2511532009 delLast_2009 (NodeDLL_2511532009 head_2009) {
        if (head_2009 == null) {
            return null;
        }
        if (head_2009.next_2009 == null ) {
            return null;
        }
        NodeDLL_2511532009 curr_2009 = head_2009;
        while (curr_2009.next_2009 != null) {
            curr_2009 = curr_2009.next_2009;
        }
        //update pointer previous node
        if (curr_2009.prev_2009 != null) {
            curr_2009.prev_2009.next_2009 = null;
        }
        return head_2009;
    }
    
    //fungsi menghapus node posisi tertentu
    public static NodeDLL_2511532009 delPos_2009 (NodeDLL_2511532009 head_2009, int pos_2009) {
        //jika DLL kosong
        if(head_2009 == null) {
            return head_2009;
        }
        NodeDLL_2511532009 curr_2009 = head_2009;
        //telusuri sampai ke node yang akan dihapus
        for (int i =1; curr_2009 != null && i<pos_2009; i++) {
            curr_2009 = curr_2009.next_2009;
        }
        //jika posisi tidak ditemukan
        if (curr_2009 == null) {
            return head_2009;
        }
        //update pointer
        if (curr_2009.prev_2009 != null) {
            curr_2009.prev_2009.next_2009 = curr_2009.next_2009;
        }
        if (curr_2009.next_2009 != null) {
            curr_2009.next_2009.prev_2009 = curr_2009.prev_2009;
        }
        //jika yang dihapus head
        if (head_2009 == curr_2009) {
            head_2009 = curr_2009.next_2009;
        }
        return head_2009;
    }
    //fungsi mencetak DLL
    public static void printList_2009(NodeDLL_2511532009 head_2009) {
        NodeDLL_2511532009 curr_2009 = head_2009;
        while (curr_2009 != null) {
            System.out.print(curr_2009.data_2009 + " <-> ");
            curr_2009 = curr_2009.next_2009;
        }
        System.out.println();
    }
    
    public static void main (String [] args) {
        //buat sebuah DLL
        NodeDLL_2511532009 head_2009 = new NodeDLL_2511532009 (1);
        head_2009.next_2009 = new NodeDLL_2511532009(2);
        head_2009.next_2009.prev_2009 = head_2009;
        head_2009.next_2009.next_2009 = new NodeDLL_2511532009 (3);
        head_2009.next_2009.next_2009.prev_2009 = head_2009.next_2009;
        head_2009.next_2009.next_2009.next_2009 = new NodeDLL_2511532009 (4);
        head_2009.next_2009.next_2009.next_2009.prev_2009 = head_2009.next_2009.next_2009;
        head_2009.next_2009.next_2009.next_2009.next_2009 = new NodeDLL_2511532009 (5);
        head_2009.next_2009.next_2009.next_2009.next_2009.prev_2009 = head_2009.next_2009.next_2009.next_2009;
        
        System.out.print("DLL awal : " );
        printList_2009(head_2009);
        
        System.out.print("Setelah head dihapus : " );
        head_2009 = delHead_2009(head_2009);
        printList_2009(head_2009);
        
        System.out.print("Setelah node terakhir dihapus : " );
        head_2009 = delLast_2009(head_2009);
        printList_2009(head_2009);
        
        System.out.print("menghapus node ke 2 : " );
        head_2009 = delPos_2009(head_2009,2);
        printList_2009(head_2009);
    }
    
}
