package tree.binarysearch;

public class Node {
    int key;
    Node parent;
    Node left;
    Node right;

    @Override
    public String toString() {
        return key + "";
    }
}
