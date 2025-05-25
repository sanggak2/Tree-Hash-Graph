package graph.unionfind;

public class UnionFindTest {
    public static void main(String[] args) {
        UnionFind u = new UnionFind();
        Node a = u.makeSet(1);
        Node b = u.makeSet(2);
        Node c = u.makeSet(3);
        Node d = u.makeSet(4);
        Node e = u.makeSet(5);

        System.out.println(u.union(a, b));
        System.out.println(u.union(c, b));
        System.out.println(u.union(e, d));
        System.out.println(u.union(c, d));
        System.out.println("u.find(d) = " + u.find(d));
    }
}
