// Last updated: 7/5/2026, 2:35:43 AM
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;

        for(int num : nums) {
            maxNumber = Math.max(maxNumber, num);
        }

        int[] values = new int[maxNumber+1];

        for(int num : nums) {
            values[num] += num;
        }

        int[] dp = new int[maxNumber+3];

        dp[maxNumber+2] = 0;
        dp[maxNumber+1] = 0;

        for(int i = maxNumber; i >= 0; i--) {
            dp[i] = Math.max(values[i] + dp[i+2], dp[i+1]);
        }

        return dp[0];


    }

    // public int delete(int i, int[] nums) {

    //     if(nums.length == 0) return 0;

    //     List<Integer> values = new ArrayList<>();

    //     for(int j : nums) {
    //         if(j == i+1 || j == i-1) continue;

    //         if(j == i && !flag) {
    //             flag = true;
    //             continue;
    //         }
    //         values.add(j);
    //     }

        
    // }
}