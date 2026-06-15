package QueueDS.Implementation;

class RecentCounter {

    Queue q;

    public RecentCounter(int capacity) {
        q = new Queue(capacity);
    }

    public int ping(int t) {
        q.enqueue(t);
        while(!q.isEmpty() && q.peek() < t - 3000) {
            q.dequeue();
        }
        System.out.println(q.rear - q.front + 1);
        return q.rear - q.front + 1;
    }
}
