package tree.avl.chansu;

public class AVLTest {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(11);
        tree.add(30);
        tree.add(4);
        tree.add(25);
        tree.add(40);

        tree.add(27);
        tree.add(28);
        tree.levelOrder();

        System.out.println("\ndelete\n");

//        tree.deleteAVL(tree.root, 7);
//        tree.deleteAVL(tree.root, 5);
        tree.deleteAVL(tree.root, 10);
        tree.levelOrder();
    }
}
