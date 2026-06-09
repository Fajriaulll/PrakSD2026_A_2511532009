package pekan9_2511532009;

public class BtreeDriver_2511532009 {
    public static void main(String[] args) {
        // membuat pohon
        BTree_2511532009 tree_2009 = new BTree_2511532009();
        System.out.print("Jumlah Simpul Awal Pohon : ");
        System.out.println(tree_2009.countNodes_2009());

        // menambahkan simpul data 1
        Node_2511532009 root_2009 = new Node_2511532009(1);

        // menjadikan simpul 1 sebagai root
        tree_2009.setRoot_2009(root_2009);
        System.out.print("Jumlah simpul jika hanya ada root :");
        System.out.println(tree_2009.countNodes_2009());

        Node_2511532009 node2_2009 = new Node_2511532009(2);
        Node_2511532009 node3_2009 = new Node_2511532009(3);
        Node_2511532009 node4_2009 = new Node_2511532009(4);
        Node_2511532009 node5_2009 = new Node_2511532009(5);
        Node_2511532009 node6_2009 = new Node_2511532009(6);
        Node_2511532009 node7_2009 = new Node_2511532009(7);
        Node_2511532009 node8_2009 = new Node_2511532009(8);
        Node_2511532009 node9_2009 = new Node_2511532009(9);

        root_2009.setLeft_2009(node2_2009);
        node2_2009.setLeft_2009(node4_2009);
        node2_2009.setRight_2009(node5_2009);
        node4_2009.setRight_2009(node8_2009);
        root_2009.setRight_2009(node3_2009);
        node3_2009.setLeft_2009(node6_2009);
        node3_2009.setRight_2009(node7_2009);
        node6_2009.setLeft_2009(node9_2009);

        // set root
        tree_2009.setCurrent_2009(tree_2009.getRoot_2009());
        System.out.println("Menampilkan simpul terakhir :");
        System.out.println(tree_2009.getCurrent_2009().getData_2009());
        System.out.println("Jumlah simpul setelah simpul 7 ditambahkan :");
        System.out.println(tree_2009.countNodes_2009());

        System.out.println("InOrder:");
        tree_2009.printInorder_2009();
        System.out.println("\nPreOrder:");
        tree_2009.printPreorder_2009();
        System.out.println("\nPostOrder:");
        tree_2009.printPostorder_2009();

        System.out.println("\nMenampilkan simpul dalam bentuk pohon : ");
        tree_2009.print_2009();
    }
}
