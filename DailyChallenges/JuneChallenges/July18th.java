package DailyChallenges.JuneChallenges;


public class July18th {
    public static void main(String[] args) {
        int hour = 3;
        int minutes = 19;

        double ans = angleClock(hour, minutes);
        System.out.println(ans);
    }

    public static double angleClock(int hour, int minutes) {
        double totalAngle = Math.abs(((minutes / 5.0) - hour) * 30.0);

        System.out.println(totalAngle);
        double angle = totalAngle  - (minutes * 30.0 / 60.0);

        return Math.abs(angle);
    }
}