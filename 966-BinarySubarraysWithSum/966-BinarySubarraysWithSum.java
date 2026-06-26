// Last updated: 6/26/2026, 8:54:17 AM
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums.length == 0) return 0;

        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;

        int sum = 0;

        map.put(0, 1);

        // map.put(-1,k);
        for(int i=0; i< nums.length; i++) {
            sum+= nums[i]; 

            if(map.containsKey(sum - goal)) {
                count += map.get(sum - goal);

            }
            if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }

        return count;

    }
}