package DailyChallenges.JuneChallenges;
public class June2Optimized {
    public static void main(String[] args) {
        int[] landStartTime = {2 , 8};
        int[] landDuration = {4 , 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        int ans = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(ans);
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int[] landInterval = new int[landDuration.length];
        int[] waterInterval =new int[waterDuration.length];

        // for(int i =0 ; i < landDuration.length; i++) {
        //     landInterval[i] = landStartTime[i] + landDuration[i];
        // }

        // for(int i =0 ; i < waterDuration.length ; i++) {
        //     waterInterval[i] = waterStartTime[i] + waterDuration[i];
        // }

        // Arrays.sort(landInterval);
        // Arrays.sort(waterInterval);
        

        for(int num : landInterval) {
            System.out.print(num + " ");
        }
        for(int num : waterInterval) {
            System.out.print(num + " ");
        }
        return 0;
    }
}
