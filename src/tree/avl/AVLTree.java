package tree.avl;

public class AVLTree {
    private Node root;

    public void add(int data){
        Node newNode = new Node(data);
        if(root == null) root = newNode;
        else root = insertNode(root, newNode);
    }

    private Node insertNode(Node x, Node newNode){
        if(x == null) return newNode;
        else if(x.data > newNode.data)
            x.left = insertNode(x.left, newNode);
        else x.right = insertNode(x.right, newNode);

        changeNodeHeight(x);
        return rotate(x);
    }

    public Node remove(Node cur, int key){
        if(cur == null) throw new RuntimeException("Tree is empty");
        if(cur.data > key) cur.left = remove(cur.left, key);
        else if(cur.data < key) cur.right = remove(cur.right, key);
        else{
            if(cur.left != null) {
                Node change = getLargestNode(cur.left);
                int removeKey = cur.data;
                swapNode(cur, change);
                cur.left = remove(cur.left, removeKey);
            }
            else if(cur.right != null) {
                Node change = getSmallestNode(cur.right);
                int removeKey = cur.data;
                swapNode(cur, change);
                cur.right = remove(cur.right, removeKey);
            }
            else {
                return null;
            }
        }

        changeNodeHeight(cur);
        return rotate(cur);
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

    //노드 키값 스왑
    private void swapNode(Node cur, Node change) {
        int temp = cur.data;
        cur.data = change.data;
        change.data = temp;
    }

    public int search(int data){
        return -1;
    }

    private Node rotate(Node x){
        int nodeBalance = getBalance(x);
        if(Math.abs(nodeBalance) >= 2){
            if(nodeBalance > 1 && getBalance(x.left) >= 0){
                x = LL_rotate(x);
            }else if(nodeBalance > 1 && getBalance(x.left) == -1){
                x.left = RR_rotate(x.left);
                x =LL_rotate(x);
            }else if(nodeBalance < -1 && getBalance(x.right) <= 0){
                x = RR_rotate(x);
            }else if(nodeBalance < -1 && getBalance(x.right) == 1){
                x.right = LL_rotate(x.right);
                x =RR_rotate(x);
            }
        }
        return x;
    }

    private int getHeight(Node x){
        int leftHeight = (x.left != null) ? x.left.height : -1;
        int rightHeight = (x.right != null) ? x.right.height : -1;
        return Math.max(leftHeight, rightHeight);
    }

    private int getBalance(Node x){
        int leftHeight = (x.left != null) ? x.left.height : -1;
        int rightHeight = (x.right != null) ? x.right.height : -1;
        return leftHeight-rightHeight;
    }

    private void changeNodeHeight(Node x){
        x.height = getHeight(x);
    }

    private Node LL_rotate(Node p){
        Node L = p.left;
        L.right = p;
        p.left = L.right;

        changeNodeHeight(p);
        changeNodeHeight(L);
        return L;
    }

    private Node RR_rotate(Node p){
        Node R = p.right;
        R.left = p;
        p.right = R.left;

        changeNodeHeight(p);
        changeNodeHeight(R);
        return R;
    }
}
