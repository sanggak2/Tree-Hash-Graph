package tree.avl.chansu;

import tree.binarysearch.BinarySearchTree;
import tree.binarysearch.Node;

public class AVLTree extends BinarySearchTree {
    Node root;
    @Override
    public void add(int key){
        //insertNode(by BST)
        Node newNode = new Node();
        newNode.key = key;
        newNode.height = 0;
        root = insertNode(root, newNode);

        //find xyz (rebalance)
        System.out.println("\ninsert "+key+"!");
        rebalance(newNode);
        System.out.println("newNode.height = " + newNode.height);
        System.out.println("root.height = " + root.height +" : "+root.key);
    }

    private void rebalance(Node x) {

        if(Math.abs(getBalance(x)) > 1) {
            System.out.println("balance!");
            rotate(x);
        }
        setHeight(x);
        if(x == root) return;
        System.out.println(x.key+".height = " + x.height);

        rebalance(x.parent);
    }

    private void rotate(Node x) {
        boolean LR1, LR2;   // true : L | false : R

        LR1 = getBalance(x) > 0;
        Node y = LR1 ? x.left : x.right;

        LR2 = getBalance(y) > 0;

        //LL RR LR RL
        if(LR1 && LR2) {
            System.out.println("LL!");
            rightRotate(x);
        }
        else if(!LR1 && !LR2) {
            System.out.println("RR!");
            leftRotate(x);
        }
        else if(LR1 && !LR2){
            System.out.println("LR!");
            leftRotate(y);
            rightRotate(x);
        }
        else if(!LR1 && LR2){
            System.out.println("RL!");
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

    private Node insertNode(Node cur, Node newNode) {
        if(cur == null) return newNode;
        else if(cur.key > newNode.key){
            cur.left = insertNode(cur.left, newNode);
            cur.left.parent = cur;
        }
        else {
            cur.right = insertNode(cur.right, newNode);
            cur.right.parent = cur;
        }
        return cur;
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
