package queue;

import java.util.Arrays;

public class CircularQueue<T> {
    private int front = 0;
    private int rear = 0;
    private final Object[] queue;
    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity+1;
        queue = new Object[this.capacity];
    }

    public void offer(T element) {
        // 큐가 꽉 찼을 때
        if (size() == capacity-1) return;

        queue[rear] = element;
        rear = ++rear%capacity;
    }

    public T poll(){
        // 큐가 비었을 때
        if (front==rear) return null;

        T temp = (T)queue[front];
        front = ++front%capacity;
        return temp;
    }

    public T peek(){
        if (front==rear) return null;   // 큐가 비었을 때
        return (T)queue[front];
    }

    public int size(){
        return ((rear-front)+capacity)%capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
