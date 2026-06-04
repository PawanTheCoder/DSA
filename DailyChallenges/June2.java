package DailyChallenges;


public class June2 {
    public static void main(String[] args) {
        int[] landStartTime = {79};
        int[] landDuration = {51};
        int[] waterStartTime = {99};
        int[] waterDuration = {79};

        int ans = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(ans);
    }
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // int minWaitingTime = Integer.MAX_VALUE;
        // for(int startTime : landStartTime) {
        //     minWaitingTime = Math.min(minWaitingTime , startTime);
        // }
        // for(int startTime : waterStartTime) {
        //     minWaitingTime = Math.min(minWaitingTime , startTime);
        // }

        int totalTime = Integer.MAX_VALUE;
        // If we select waterTime first
        for(int i =0 ; i < waterDuration.length ; i++) {
            for(int j =0 ; j < landDuration.length ; j++) {
                int currentSlideTime = waterStartTime[i] + waterDuration[i];

                if(landStartTime[j] > currentSlideTime) {
                    totalTime = Math.min(totalTime , landStartTime[j] + landDuration[j]);
                }else {
                    totalTime = Math.min(totalTime , currentSlideTime + landDuration[j]);
                }
            }
        }

        // If we select landTime first
        for(int i =0 ; i < landDuration.length ; i++) {
            for(int j =0 ; j < waterDuration.length ; j++) {
                int currentSlideTime = landStartTime[i] + landDuration[i];

                if(waterStartTime[j] > currentSlideTime) {
                    totalTime = Math.min(totalTime , waterStartTime[j] + waterDuration[j]);
                }else {
                    totalTime = Math.min(totalTime , currentSlideTime + waterDuration[j]);
                }
            }
        }

        return totalTime;
    }
}
