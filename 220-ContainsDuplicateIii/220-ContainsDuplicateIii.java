// Last updated: 6/26/2026, 8:54:49 AM
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet();
        for(int i=0;i<nums.length;i++){
            if(set.floor((long) nums[i])!=null && nums[i]-set.floor((long) nums[i]) <=t)return true;
            if(set.ceiling((long) nums[i])!=null && set.ceiling((long) nums[i]) - nums[i] <=t)return true;
            set.add((long) nums[i]);
            if(set.size()>k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}