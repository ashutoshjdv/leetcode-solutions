// Last updated: 6/26/2026, 8:54:46 AM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i==0)prefix[i]=nums[i];
            else{
                prefix[i]=prefix[i-1]*nums[i];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1)suffix[i]=nums[i];
            else{
                suffix[i]=suffix[i+1]*nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(i==0)result[i]=suffix[i+1];
            else if(i==n-1)result[i]=prefix[i-1];
            else{
                result[i]=prefix[i-1]*suffix[i+1];
            }
        }
        return result;
    }
}