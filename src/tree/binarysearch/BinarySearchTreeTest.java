package tree.binarysearch;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        test.add(2);
        test.add(8);
        test.add(6);
        test.add(1);
        test.add(10);
        test.add(15);
        test.add(3);
        test.add(12);
        test.add(11);
        test.levelOrder();
    }
}
