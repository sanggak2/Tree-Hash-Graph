package tree.binarysearch;

public class BinarySearchTree {
    Node root;

    public void add(int key){
        Node newNode = new Node();
        newNode.key = key;

        if(root == null) root = newNode;
        else{
            root = insertNode(root, newNode);
        }
    }

    private Node insertNode(Node cur, Node newNode) {
        if(cur == null) return newNode;
        else if(cur.key > newNode.key)
            cur.left = insertNode(cur.left, newNode);
        else
            cur.right = insertNode(cur.right, newNode);

        return root;
    }

    public Node remove(Node cur, int key){
        if(root == null) throw new RuntimeException("Tree is empty");

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

    public int search(int key){
        return searchNode(root, key).key;
    }

    private Node searchNode(Node cur, int key) {
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
    private Node getSmallestNode(Node cur){
        if(cur.left == null) return cur;
        return getSmallestNode(cur.left);
    }

    //제일 큰 값 찾기
    private Node getLargestNode(Node cur){
        if(cur.right == null) return cur;
        return getSmallestNode(cur.right);
    }
}
