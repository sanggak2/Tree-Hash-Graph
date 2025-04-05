package queue;

// n명의 사람들이 원형으로 앉아있을 때, k번째 사람을 n-1번 죽이고
// 마지막으로 남은 사람을 출력하는 문제
public class JosephsProblem {
    public static void main(String[] args) {
        int n = 9;  // 사람 수
        int k = 3;  // k번째
        CircularQueue<Integer> queue = new CircularQueue<>(n);
        for (int i = 1; i <= n; i++) queue.offer(i);

        while(queue.size() > 1){
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("died : "+queue.poll());
        }
        System.out.println("winner = " + queue.peek());
    }
}
