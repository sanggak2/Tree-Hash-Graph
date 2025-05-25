package graph.unionfind;

import java.util.Objects;

public class Node {
    int rank = 0;
    Node parent = this;
    int value;

    public Node(int value) {
        this.value = value;
    }

    // value 기준으로 equals와 hashCode 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        return value == ((Node) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value+"";
    }
}
