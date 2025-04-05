package tree.heap;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        MakeHeap maxHeap =
                new MakeHeap(new int[]{2, 8, 6, 1, 10, 15, 3, 12, 11});
        System.out.println("makeHeap() = " + Arrays.toString(maxHeap.makeHeap()));
    }
}
