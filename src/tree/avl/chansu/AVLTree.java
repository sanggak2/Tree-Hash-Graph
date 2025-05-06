package tree.avl.chansu;

import tree.binarysearch.BinarySearchTree;
import tree.binarysearch.Node;

public class AVLTree extends BinarySearchTree {
    @Override
    public void add(int key){
        //insertNode(by BST)
        Node newNode = new Node();
        newNode.key = key;
        newNode.height = 0;
        root = insertNode(root, newNode);

        //rebalance
        rebalance(newNode);
    }

    public void deleteAVL(Node cur, int key){
        cur = searchNode(cur, key).parent;
        super.delete(root, key);
        levelOrder();
        rebalance(cur);
    }

    private void rebalance(Node x) {
        System.out.println("rebalance : x = " + x);
        if(x == null) return;
        if(Math.abs(getBalance(x)) > 1) rotate(x);
        setHeight(x);

        rebalance(x.parent);
    }

    private void rotate(Node x) {
        boolean LR1, LR2;   // true : L | false : R

        LR1 = getBalance(x) > 0;
        Node y = LR1 ? x.left : x.right;

        LR2 = getBalance(y) > 0;

        //LL RR LR RL
        if(LR1 && LR2) {
            System.out.println("LL");
            rightRotate(x);
        }
        else if(!LR1 && !LR2) {
            System.out.println("RR : x "+x);
            leftRotate(x);
        }
        else if(LR1 && !LR2){
            System.out.println("LR : y "+y+" : x "+x);
            leftRotate(y);
            rightRotate(x);
            System.out.print("rotate : ");
            levelOrder();
        }
        else if(!LR1 && LR2){
            System.out.println("RL");
            rightRotate(y);
            leftRotate(x);
        }
    }

    private int getBalance(Node x) {
        int leftHeight = x.left == null ? -1 : x.left.height;
        int rightHeight = x.right == null ? -1 : x.right.height;
        return leftHeight - rightHeight;
    }

    private void setHeight(Node x) {
        int leftHeight = x.left == null ? -1 : x.left.height;
        int rightHeight = x.right == null ? -1 : x.right.height;
        System.out.println("setHeight : x: "+x+", left: "+x.left+", right: "+x.right);
        x.height = Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public void leftRotate(Node x){
        super.leftRotate(x);
        setHeight(x);
    }

    @Override
    public void rightRotate(Node x){
        super.rightRotate(x);
        setHeight(x);
    }
}
