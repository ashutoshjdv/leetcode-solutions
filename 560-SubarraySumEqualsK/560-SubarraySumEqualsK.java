// Last updated: 6/26/2026, 8:54:29 AM
class Solution {
    public int subarraySum(int[] nums, int k) {
        //[0,1,2,3]
        if(nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int prefix = 0;
        int output=0;

        map.put(0,1);
        for(int num : nums){
            
            prefix += num;

            output += map.getOrDefault(prefix-k, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) +1);

        }

        return output;

    }
}