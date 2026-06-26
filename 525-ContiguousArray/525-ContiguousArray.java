// Last updated: 6/26/2026, 8:54:33 AM
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();


        int distance = 0;

        map.put(0, -1);
        if(nums.length == 0) return 0;

        for(int i=0; i< nums.length;i++) {
            if(nums[i] == 0) nums[i] = -1;
        }


        int sum = 0;

        for(int i=0; i< nums.length; i++) {

            sum+= nums[i];

            if(map.containsKey(sum)) {
                distance = Math.max(distance, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }

        return distance;
    }
}