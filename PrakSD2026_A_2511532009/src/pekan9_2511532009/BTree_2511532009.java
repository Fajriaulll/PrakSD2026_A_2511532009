package pekan9_2511532009;

public class BTree_2511532009 {
    private Node_2511532009 root_2009;
    private Node_2511532009 currentNode_2009;

    public BTree_2511532009() {
        root_2009 = null;
    }

    public boolean search_2009(int data_2009) {
        return search_2009(root_2009, data_2009);
    }

    private boolean search_2009(Node_2511532009 node_2009, int data_2009) {
        if (node_2009.getData_2009() == data_2009)
            return true;
        if (node_2009.getLeft_2009() != null)
            if (search_2009(node_2009.getLeft_2009(), data_2009))
                return true;
        if (node_2009.getRight_2009() != null)
            if (search_2009(node_2009.getRight_2009(), data_2009))
                return true;
        return false;
    }

    public void printInorder_2009() {
        root_2009.printInorder_2009(root_2009);
    }

    public void printPreorder_2009() {
        root_2009.printPreorder_2009(root_2009);
    }

    public void printPostorder_2009() {
        root_2009.printPostorder_2009(root_2009);
    }

    public Node_2511532009 getRoot_2009() {
        return root_2009;
    }

    public boolean isEmpty_2009() {
        return root_2009 == null;
    }

    public int countNodes_2009() {
        return countNodes_2009(root_2009);
    }

    private int countNodes_2009(Node_2511532009 node_2009) {
        int count_2009 = 1;
        if (node_2009 == null) {
            return 0;
        } else {
            count_2009 += countNodes_2009(node_2009.getLeft_2009());
            count_2009 += countNodes_2009(node_2009.getRight_2009());
            return count_2009;
        }
    }

    public void print_2009() {
        root_2009.print_2009();
    }

    public Node_2511532009 getCurrent_2009() {
        return currentNode_2009;
    }

    public Node_2511532009 setCurrent_2009(Node_2511532009 node_2009) {
        return currentNode_2009 = node_2009;
    }

    public void setRoot_2009(Node_2511532009 root_2009) {
        this.root_2009 = root_2009;
    }
}
