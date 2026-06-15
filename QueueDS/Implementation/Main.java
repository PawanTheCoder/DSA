package QueueDS.Implementation;

public class Main {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter(10);

        recentCounter.ping(1);
        recentCounter.ping(100);
        recentCounter.ping(3001);
        recentCounter.ping(3002);
    }
}
