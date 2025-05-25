package graph.unionfind;

import java.util.HashSet;

public class UnionFind {
    HashSet<Node> set = new HashSet<>();

    Node makeSet(int value){
        Node newNode = new Node(value);
        set.add(newNode);
        return newNode;
    }

    Node find(Node x){
        while(x != x.parent)
            x = x.parent;
        return x;
    }

    Node union(Node x, Node y){
        x = find(x);
        y = find(y);

        if (x == y) return x;
        if(x.rank < y.rank){
            Node temp = x;
            x = y;
            y = temp;
        }
        else if(x.rank == y.rank) x.rank++;

        y.parent = x;
        return x;
    }
}
