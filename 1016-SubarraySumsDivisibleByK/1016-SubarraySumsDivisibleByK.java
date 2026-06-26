// Last updated: 6/26/2026, 8:54:15 AM
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int count =0;

        map.put(0,1);

        int sum = 0;

        for(int i=0; i< nums.length; i++) {
            sum += nums[i];

            int rem = ((sum % k) + k) % k;

            if(map.containsKey(rem % k)) {
                int counter = map.get(rem%k);
                count += counter;
                map.put(rem%k, counter+1);
            } 
            else map.put(rem % k, 1);
        }

        return count;
    }
}