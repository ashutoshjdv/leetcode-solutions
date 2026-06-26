// Last updated: 6/26/2026, 8:54:50 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))return true;
            else{
                map.put(nums[i],1);
            }
        }
        return false;
    }
}