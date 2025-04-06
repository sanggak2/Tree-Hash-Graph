package tree.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] arr;

    public MaxHeap(int[] arr) {
        this.arr = arr;
        makeHeap();
    }

    // 배열 최대힙으로 만들기
    private void makeHeap() {
        for (int i = arr.length-1; i >= 0; i--) {
            heapifyDown(arr, i, arr.length);
        }
    }

    // 힙 배열 요소 추가
    public void insert(int value) {
        int size = arr.length;
        arr = Arrays.copyOf(arr, arr.length+1);
        arr[size] = value;

        int parent = (size-1)/2;
        upHeap(size, parent);
    }

    // 가장 큰 값 검색
    public int findMax() {
        return arr[0];
    }

    // 가장 큰 값 삭제
    public int deleteMax() {
        int max = arr[0];
        swap(arr, 0, arr.length-1);
        arr = Arrays.copyOf(arr, arr.length-1);
        heapifyDown(arr, 0, arr.length);
        return max;
    }

    // HeapSort : 힙정렬
    public int[] sort() {
        int[] temp = Arrays.copyOf(arr, arr.length);
        heapSort(temp, arr.length-1);
        return temp;
    }

    private void heapSort(int[] arr, int lastIndex) {
        if (lastIndex < 2) return;
        swap(arr, 0, lastIndex);
        heapifyDown(arr, 0, lastIndex-1);
        heapSort(arr, lastIndex-1);
    }

    private void upHeap(int k, int parent) {
        if(arr[k] > arr[parent]) {
            swap(arr, k, parent);
            upHeap(parent, (parent-1)/2);
        }
    }

    private void heapifyDown(int[] arr, int k, int length) {
        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // 둘다 없는경우
        if (left >= length) return;

        // 왼쪽만 있는 경우
        if(right >= length){
            if(arr[k] > arr[left]) return;
            swap(arr, k, left);
        }

        // 다 있는 경우
        boolean isLeft = arr[left] > arr[right];    // 왼쪽이 더 크냐
        if(isLeft){
            if(arr[k] < arr[left]) {
                swap(arr, k, left);
                heapifyDown(arr, left, length);
            }
        }
        else{   // 오른쪽이 더 크냐
            if(arr[k] < arr[right]) {
                swap(arr, k, right);
                heapifyDown(arr, right, length);
            }
        }


    }

    private void swap(int[] arr, int parent, int child) {
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
