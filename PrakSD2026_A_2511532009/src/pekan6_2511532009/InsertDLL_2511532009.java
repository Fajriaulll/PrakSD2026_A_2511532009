package pekan6_2511532009;
public class InsertDLL_2511532009 {
    //menambahkan node di awal kiri
    static NodeDLL_2511532009 InsertBegin_2009 (NodeDLL_2511532009 head_2009, int data_2009) {
        //buat node baru
        NodeDLL_2511532009 new_node_2009 = new NodeDLL_2511532009 (data_2009);
        //jadikan pointer nextnya head
        new_node_2009.next_2009 = head_2009;
        // jadikan pointer prev head ke new_node
        if (head_2009 != null) {
            head_2009.prev_2009 = new_node_2009;
        }
        return new_node_2009;
    }
    
    //fungsi menambahkan node di akhir
    public static NodeDLL_2511532009 insertEnd_2009 (NodeDLL_2511532009 head_2009, int newData_2009) {
        //buat node baru
        NodeDLL_2511532009 newNode_2009 = new NodeDLL_2511532009 (newData_2009);
        //jika dll null jadikan head
        if(head_2009 == null) {
            head_2009 = newNode_2009;
        }
        else {
            NodeDLL_2511532009 curr_2009 = head_2009;
            while (curr_2009.next_2009 != null) {
                curr_2009 = curr_2009.next_2009;
            }
            curr_2009.next_2009 = newNode_2009;
            newNode_2009.prev_2009 = curr_2009;
        }
        return head_2009;
    }
    
    //fungsi menambahkan node  di posisi tertentu 
    public static NodeDLL_2511532009 insertAtPosition_2009 (NodeDLL_2511532009 head_2009, int pos_2009, int new_data_2009) {
        //buat node baru
        NodeDLL_2511532009 new_node_2009 = new NodeDLL_2511532009 (new_data_2009);
        if (pos_2009== 1) {
            new_node_2009.next_2009 = head_2009;
            if (head_2009 != null) {
                head_2009.prev_2009 = new_node_2009;}
            head_2009 = new_node_2009;
            return head_2009;
            }
        NodeDLL_2511532009 curr_2009 = head_2009;
        for ( int i = 1; i <pos_2009 -1 && curr_2009 != null; i++) {
            curr_2009 = curr_2009.next_2009;}
        if(curr_2009 == null) {
            System.out.println("Posisi tidak ada");
            return head_2009;
        }
        
        new_node_2009.prev_2009 = curr_2009;
        new_node_2009.next_2009 = curr_2009.next_2009;
        curr_2009.next_2009 = new_node_2009;
        if (new_node_2009.next_2009 != null) {
            new_node_2009.next_2009.prev_2009 = new_node_2009;
        }
        return head_2009;
        }
    
    public static void printList_2009 (NodeDLL_2511532009 head_2009) {
        NodeDLL_2511532009 curr_2009 = head_2009;
        while (curr_2009 != null) {
            System.out.print(curr_2009.data_2009 + " <-> ");
            curr_2009 = curr_2009.next_2009;    
        }
        System.out.println();
    }
    
    public static void main (String [] args) {
        //membuat dll 2 <-> 1 <-> 5
        NodeDLL_2511532009 head_2009 = new NodeDLL_2511532009(2);
        head_2009.next_2009 = new NodeDLL_2511532009(3);
        head_2009.next_2009.prev_2009 = head_2009;
        head_2009.next_2009.next_2009 = new NodeDLL_2511532009 (5);
        head_2009.next_2009.next_2009.prev_2009 = head_2009.next_2009;
        //cetak DLL awal
        System.out.print("DLL Awal : ");
        printList_2009 (head_2009);
        //tambah 1 di awal
        head_2009 = InsertBegin_2009 (head_2009,1);
        System.out.print("simpul 1 ditambah di awal: ");
        printList_2009(head_2009);
        //tambah 6 di akhir
        System.out.print("simpul 6 ditambah di akhir: ");
        int data_2009 = 6;
        head_2009 = insertEnd_2009 (head_2009, data_2009);
        printList_2009(head_2009);
        //menambah node 4 di posisi 4
        System.out.print("tambah node 4 di posisi 4: ");
        int data2_2009 = 4;
        int pos_2009 = 4;
        head_2009 = insertAtPosition_2009 (head_2009, pos_2009, data2_2009);
        printList_2009(head_2009);
        }
    
}
