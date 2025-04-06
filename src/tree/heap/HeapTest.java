package tree.heap;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap =
                new MaxHeap(new int[]{2, 8, 6, 1, 10, 15, 3, 12, 11});

        // 객체 생성 시 바로 힙이 되도록 패치
        //System.out.println("makeHeap() = " + Arrays.toString(maxHeap.makeHeap()));
        
        maxHeap.insert(14);
        System.out.println("insert() = " + maxHeap);
        System.out.println("findMax() = " + maxHeap.findMax());
        maxHeap.deleteMax();
        System.out.println("deleteMax() = " + maxHeap);
        System.out.println("heapSort() = " + Arrays.toString(maxHeap.sort()));
    }
}
