// Last updated: 6/26/2026, 8:54:34 AM
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        // prefixSet.add(0,0);

        map.put(0,-1);

        int sum =0;

        for(int i = 0; i< nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum % k)) {

                if(i - map.get(sum % k) >= 2) return true;

            }
            else map.put(sum % k, i);

        }

        return false;

    }
}