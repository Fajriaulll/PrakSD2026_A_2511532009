package pekan9_2511532009;

public class Node_2511532009 {
    int data_2009; // bisa diganti dengan string
    Node_2511532009 left_2009;
    Node_2511532009 right_2009;

    public Node_2511532009(int data_2009) {
        this.data_2009 = data_2009;
        left_2009 = null;
        right_2009 = null;
    }

    public void setLeft_2009(Node_2511532009 node_2009) {
        if (left_2009 == null)
            left_2009 = node_2009;
    }

    public void setRight_2009(Node_2511532009 node_2009) {
        if (right_2009 == null)
            right_2009 = node_2009;
    }

    public Node_2511532009 getLeft_2009() {
        return left_2009;
    }

    public Node_2511532009 getRight_2009() {
        return right_2009;
    }

    public int getData_2009() {
        return data_2009;
    }

    public void setData_2009(int data_2009) {
        this.data_2009 = data_2009;
    }

    void printPreorder_2009(Node_2511532009 node_2009) {
        if (node_2009 == null)
            return;
        System.out.print(node_2009.data_2009 + " ");
        printPreorder_2009(node_2009.left_2009);
        printPreorder_2009(node_2009.right_2009);
    }

    void printPostorder_2009(Node_2511532009 node_2009) {
        if (node_2009 == null)
            return;
        printPostorder_2009(node_2009.left_2009);
        printPostorder_2009(node_2009.right_2009);
        System.out.print(node_2009.data_2009 + " ");
    }

    void printInorder_2009(Node_2511532009 node_2009) {
        if (node_2009 == null)
            return;
        printInorder_2009(node_2009.left_2009);
        System.out.print(node_2009.data_2009 + " ");
        printInorder_2009(node_2009.right_2009);
    }

    public String print_2009() {
        return this.print_2009("", true, "");
    }

    public String print_2009(String prefix_2009, boolean isTail_2009, String sb_2009) {
        if (right_2009 != null) {
            right_2009.print_2009(prefix_2009 + (isTail_2009 ? "|   " : "   "), false, sb_2009);
        }
        System.out.println(prefix_2009 + (isTail_2009 ? "\\--" : "/--") + data_2009);
        if (left_2009 != null) {
            left_2009.print_2009(prefix_2009 + (isTail_2009 ? "   " : "|   "), true, sb_2009);
        }
        return sb_2009;
    }
}
