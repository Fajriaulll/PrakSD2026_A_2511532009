package pekan5_2511532009;

public class TambahSLL_2511532009 {
    public static NodeSLL_2511532009 insertAtFront_2009(NodeSLL_2511532009 head_2009, int value_2009) {
        NodeSLL_2511532009 new_node_2009 = new NodeSLL_2511532009(value_2009);
        new_node_2009.next_2009 = head_2009;
        return new_node_2009;
    }

    // fungsi menambahkan node di akhir SLL
    public static NodeSLL_2511532009 insertAtEnd_2009(NodeSLL_2511532009 head_2009, int value_2009) {
    		//buat sebuah node dengan sebuah nilai
        NodeSLL_2511532009 newNode_2009 = new NodeSLL_2511532009(value_2009);
        // jika list kosong maka node jadi head
        if (head_2009 == null) {
            return newNode_2009;
        }
        // simpan head ke variabel sementara
        NodeSLL_2511532009 last_2009 = head_2009;
        // telusuri ke node akhir
        while (last_2009.next_2009 != null) {
            last_2009 = last_2009.next_2009;
        }
        // ubah pointer
        last_2009.next_2009 = newNode_2009;
        return head_2009;
    }

    static NodeSLL_2511532009 GetNode_2009(int data_2009) {
        return new NodeSLL_2511532009(data_2009);
    }

    static NodeSLL_2511532009 insertPos_2009(NodeSLL_2511532009 headNode_2009, int position_2009, int value_2009) {
        NodeSLL_2511532009 head_2009 = headNode_2009;
        if (position_2009 < 1)
            System.out.println("Invalid Position");
        if (position_2009 == 1) {
            NodeSLL_2511532009 new_node_2009 = new NodeSLL_2511532009(value_2009);
            new_node_2009.next_2009 = head_2009;
            return new_node_2009;
        } else {
            while (position_2009-- != 0) {
                if (position_2009 == 1) {
                    NodeSLL_2511532009 newNode_2009 = GetNode_2009(value_2009);
                    newNode_2009.next_2009 = headNode_2009.next_2009;
                    headNode_2009.next_2009 = newNode_2009;
                    break;
                }
                headNode_2009 = headNode_2009.next_2009;
            }
            if (position_2009 != 1)
                System.out.println("Posisi di luar jangkauan");
        }
        return head_2009;
    }

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

    public static void main(String[] args) {
    	// buat linked list 2->3->5->6
        NodeSLL_2511532009 head_2009 = new NodeSLL_2511532009(2);
        head_2009.next_2009 = new NodeSLL_2511532009(3);
        head_2009.next_2009.next_2009 = new NodeSLL_2511532009(5);
        head_2009.next_2009.next_2009.next_2009 = new NodeSLL_2511532009(6);
        
        // cetak list asli
        System.out.print("Senarai berantai awal: ");
        printList_2009(head_2009);
        
        //tambahkan node baru didepan
        System.out.print("tambah 1 simpul di depan: ");
        int data_2009 = 1;
        head_2009 = insertAtFront_2009(head_2009, data_2009);
        
        // cetak update list
        printList_2009(head_2009);

        System.out.print("tambah 1 simpul di belakang : ");
        int data2_2009 = 7;
        head_2009 = insertAtEnd_2009(head_2009, data2_2009);
        // cetak update list
        printList_2009(head_2009);

        System.out.print("tambah 1 simpul ke data 4: ");
        int data3_2009 = 4;
        int pos_2009 = 4;
        head_2009 = insertPos_2009(head_2009, pos_2009, data3_2009);
        printList_2009(head_2009);
    }
}
