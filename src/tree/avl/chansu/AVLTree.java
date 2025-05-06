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
        rebalance(cur);
    }

    private void rebalance(Node x) {
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
            rightRotate(x);
        }
        else if(!LR1 && !LR2) {
            leftRotate(x);
        }
        else if(LR1 && !LR2){
            leftRotate(y);
            rightRotate(x);
        }
        else if(!LR1 && LR2){
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
