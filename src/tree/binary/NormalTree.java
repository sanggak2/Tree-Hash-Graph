package tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

public class NormalTree {
    Node root;
    //추가
    public void add(int key){
        Node newNode = new Node();
        newNode.key = key;
        if(root == null) root = newNode;
        else{
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                Node current = queue.poll();

                if(current.left != null)
                    queue.offer(current.left);
                else {
                    current.left = newNode;
                    break;}

                if(current.right != null)
                    queue.offer(current.right);
                else {
                    current.right = newNode;
                    break;}
            }
        }
    }


    //순회
    public void levelOrder(){
        if(root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();    //현 노드
            //출력
            System.out.println(current.key);
            //탐색
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
    }
}
