package queue;

public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(4);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("queue : "+queue);
        queue.offer(5);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        queue.offer(5);
        queue.offer(6);
        System.out.println("queue : " + queue);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
    }
}
