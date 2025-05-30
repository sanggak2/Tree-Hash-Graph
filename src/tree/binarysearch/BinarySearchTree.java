package tree.binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    public Node root;

    // 추가
    public void add(int key){
        Node newNode = new Node();
        newNode.key = key;

        if(root == null) root = newNode;
        else{
            root = insertNode(root, newNode);
        }
    }

    public Node insertNode(Node cur, Node newNode) {
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

    // 제거 1 : DeleteByCopying
    public Node remove(Node cur, int key){
        if(cur == null) throw new RuntimeException("Tree is empty");
        else if(cur.key > key) cur.left = remove(cur.left, key);
        else if(cur.key < key) cur.right = remove(cur.right, key);
        else{
            if(cur.left != null) {
                Node change = getLargestNode(cur.left);
                int removeKey = cur.key;
                swapNode(cur, change);
                cur.left = remove(cur.left, removeKey);
            }
            else if(cur.right != null) {
                Node change = getSmallestNode(cur.right);
                int removeKey = cur.key;
                swapNode(cur, change);
                cur.right = remove(cur.right, removeKey);
            }
            else {
                return null;
            }
        }
        return cur;
    }

    // 제거2 : Delete By Merging
    public Node delete(Node cur, int key){
        if(cur == null) throw new RuntimeException("Tree is empty");
        else if(cur.key > key) cur.left = delete(cur.left, key);
        else if(cur.key < key) cur.right = delete(cur.right, key);
        else{
            Node parent = cur.parent;
            Node left = cur.left;
            Node right = cur.right;
            // cur 덮어쓰기
            if(left == null) {
                cur = right;
            }
            else{
                cur = left;
                Node leftLargest = getLargestNode(left);
                leftLargest.right = right;
                if(right != null) right.parent = leftLargest;
            }
            // 부모 덮어쓰기
            if(parent == null) root = cur;
            if(cur != null) cur.parent = parent;
        }
        return cur;
    }

    // 검색
    public int search(int key){
        return searchNode(root, key).key;
    }

    //순회
    public void levelOrder(){
        if(root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();    //현 노드
            //출력
            System.out.print("("+current.parent+")"+current.key+" ");
            //탐색
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }

    // 회전
    // 왼쪽
//    Node x
//       Node y
//          Node z
    public void leftRotate(Node x){
        if(x == null) return;
        Node xParent = x.parent;
        if(x.right == null) return;
        Node y = x.right;
        Node yLeft = y.left;

        // 1. y의 부모를 x의 부모로
        y.parent = xParent;
        // 2. x부모의 자식노드를 y로
        if(xParent != null) {
            if(xParent.left == x) xParent.left = y;
            else xParent.right = y;
        }
        else root = y;
        // 3. x부모를 y로
        x.parent = y;
        // 4. y왼쪽을 x로
        y.left = x;
        // 5. x오른쪽을 y왼쪽으로
        x.right = yLeft;
        // 6. y왼쪽의 부모를 x로
        if(yLeft != null) yLeft.parent = x;
    }
    // 오른쪽
//          Node x
//       Node y
//    Node z
    public void rightRotate(Node x){
        if(x == null) return;
        Node xParent = x.parent;
        if(x.left == null) return;
        Node y = x.left;
        Node yRight = y.right;

        // 1. y의 부모를 x의 부모로
        y.parent = xParent;
        // 2. x부모의 자식노드를 y로
        if(xParent != null) {
            if(xParent.left == x) xParent.left = y;
            else xParent.right = y;
        }
        else root = y;
        // 3. x부모를 y로
        x.parent = y;
        // 4. y오른쪽을 x로
        y.right = x;
        // 5. x왼쪽을 y오른쪽으로
        x.left = yRight;
        // 6. y오른쪽의 부모를 x로
        if(yRight != null) yRight.parent = x;
    }

    // 노드 찾기
    public Node searchNode(Node cur, int key) {
        Node temp = cur;
        if(cur == null) throw new RuntimeException("값 없슈");
        else if (cur.key > key) temp = searchNode(cur.left, key);
        else if (cur.key < key) temp = searchNode(cur.right, key);
        return temp;
    }

    //노드 키값 스왑
    private void swapNode(Node cur, Node change) {
        int temp = cur.key;
        cur.key = change.key;
        change.key = temp;
    }

    //제일 작은 값 찾기
    public Node getSmallestNode(Node cur){
        if(cur.left == null) return cur;
        return getSmallestNode(cur.left);
    }

    //제일 큰 값 찾기
    public Node getLargestNode(Node cur){
        if(cur.right == null) return cur;
        return getSmallestNode(cur.right);
    }
}
