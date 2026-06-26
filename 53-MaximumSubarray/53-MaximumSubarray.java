// Last updated: 6/26/2026, 8:55:19 AM
class Solution {
    public int maxSubArray(int[] nums) {
       int max=nums[0];
       int sum=0;
        for(int i=0;i<nums.length;i++){
              sum+= nums[i];
              max=Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
       }
        return max;
    }
}