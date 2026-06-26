// Last updated: 6/26/2026, 8:55:02 AM
class Solution {
    public int maxProduct(int[] nums) {
        int maxpro=nums[0];
        int minpro=nums[0];
        int ans=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int dup=maxpro;
                maxpro=minpro;
                minpro=dup;
            }
            maxpro=Math.max(nums[i],nums[i]*maxpro);
            minpro=Math.min(nums[i],nums[i]*minpro);
            if(ans<maxpro)ans=maxpro;
        }
        return ans;
    }
}