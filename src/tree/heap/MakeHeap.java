package tree.heap;

public class MakeHeap {
    private int[] arr;

    public MakeHeap(int[] arr) {
        this.arr = arr;
    }

    public int[] makeHeap() {
        for (int i = arr.length-1; i >= 0; i--) {
            heapifyDown(i, arr.length);
        }
        return arr;
    }

    private void heapifyDown(int k, int length) {
        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // 둘다 없는경우
        if (left >= length) return;

        // 왼쪽만 있는 경우
        if(right >= length){
            if(arr[k] > arr[left]) return;
            swap(k, left);
        }

        // 다 있는 경우
        boolean isLeft = arr[left] > arr[right];    //왼쪽이 더 크냐
        if(isLeft){
            if(arr[k] < arr[left]) {
                swap(k, left);
                heapifyDown(left, length);
            }
        }
        else{
            if(arr[k] < arr[right]) {
                swap(k, right);
                heapifyDown(right, length);
            }
        }


    }

    private void swap(int parent, int child) {
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}
