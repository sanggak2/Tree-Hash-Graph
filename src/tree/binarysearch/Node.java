package tree.binarysearch;

public class Node {
    public int key;
    public Node parent;
    public Node left;
    public Node right;
    public int height;

    @Override
    public String toString() {
        return key + "";
    }
}
