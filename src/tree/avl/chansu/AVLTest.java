package tree.avl.chansu;

public class AVLTest {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(5);
        tree.add(1);
        tree.add(7);
        tree.add(3);
        tree.add(2);
        tree.add(4);

        tree.levelOrder(tree.root);
    }
}
