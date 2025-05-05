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
//        test.remove(test.root, 2);
//        test.remove(test.root, 1);
//        test.delete(test.root, 2);
//        test.delete(test.root, 1);
        test.leftRotate(test.root);
        System.out.println("test.searchNode(test.root, 12) = " + test.searchNode(test.root, 12));
        test.levelOrder(test.root);
    }
}
