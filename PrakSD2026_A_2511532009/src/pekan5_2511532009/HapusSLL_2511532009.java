package pekan5_2511532009;

public class HapusSLL_2511532009 {
    // fungsi untuk menghapus head
    public static NodeSLL_2511532009 deleteHead_2009(NodeSLL_2511532009 head_2009) {
    	// jika SLL kosong
        if (head_2009 == null)
            return null;
        // pindahkan head ke node berikutnya
        head_2009 = head_2009.next_2009;
        //return head baru
        return head_2009;
    }

    // fungsi menghapus node terakhir SLL
    public static NodeSLL_2511532009 removeLastNode_2009(NodeSLL_2511532009 head_2009) {
    	// jika list kosong, return null
        if (head_2009 == null) {
            return null;
        }
        // jika list satu node, hapus node dan return null
        if (head_2009.next_2009 == null) {
            return null;
        }
        // temukan node terakhir terakhir ke dua
        NodeSLL_2511532009 secondLast_2009 = head_2009;
        while (secondLast_2009.next_2009.next_2009 != null) {
            secondLast_2009 = secondLast_2009.next_2009;
        }
        // hapus node terakhir
        secondLast_2009.next_2009 = null;
        return head_2009;
    }
    
    // fungsi menghapus node diposisi tertentu
    public static NodeSLL_2511532009 deleteNode_2009(NodeSLL_2511532009 head_2009, int position_2009) {
        NodeSLL_2511532009 temp_2009 = head_2009;
        NodeSLL_2511532009 prev_2009 = null;
        // jika linked list null
        if (temp_2009 == null)
            return head_2009;
        // kasus 1 : head dihapus
        if (position_2009 == 1) {
            head_2009 = temp_2009.next_2009;
            return head_2009;
        }
        // kasus 2: menghapus node di tengah
        // telusuri ke node yang dihapus

        for (int i = 1; temp_2009 != null && i < position_2009; i++) {
            prev_2009 = temp_2009;
            temp_2009 = temp_2009.next_2009;
        }
        // jika ditemukan, hapus node
        if (temp_2009 != null) {
            prev_2009.next_2009 = temp_2009.next_2009;
        } else {
            System.out.println("Data tidak ada");
        }
        return head_2009;
    }
    
    // fungsi mencetak SLL
    public static void printList_2009(NodeSLL_2511532009 head_2009) {
        NodeSLL_2511532009 curr_2009 = head_2009;
        while (curr_2009.next_2009 != null) {
            System.out.print(curr_2009.data_2009 + "-->");
            curr_2009 = curr_2009.next_2009;
        }
        if (curr_2009.next_2009 == null) {
            System.out.print(curr_2009.data_2009);
        }
        System.out.println();
    }
    // kelas main
    public static void main(String[] args) {
    	// buat SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> -> null
        NodeSLL_2511532009 head_2009 = new NodeSLL_2511532009(1);
        head_2009.next_2009 = new NodeSLL_2511532009(2);
        head_2009.next_2009.next_2009 = new NodeSLL_2511532009(3);
        head_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(4);
        head_2009.next_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(5);
        head_2009.next_2009.next_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(6);
        
        // cetak list awal
        System.out.println("List awal : ");
        printList_2009(head_2009);
        // hapus head 
        head_2009 = deleteHead_2009(head_2009);
        System.out.println("List setelah head dihapus : ");
        printList_2009(head_2009);
        // hapus node terakhir
        head_2009 = removeLastNode_2009(head_2009);
        System.out.println("List setelah simpul terakhir dihapus : ");
        printList_2009(head_2009);
        // deleting node at position 2
        int position_2009 = 2;
        head_2009 = deleteNode_2009(head_2009, position_2009);
        // print list after deletion
        System.out.println("List setelah posisi 2 dihapus: ");
        printList_2009(head_2009);
    }
}
