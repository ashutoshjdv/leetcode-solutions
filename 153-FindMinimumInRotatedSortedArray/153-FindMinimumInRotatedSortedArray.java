// Last updated: 6/26/2026, 8:55:01 AM
class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int high=n-1;
        int low =0;
        int min = high;
        while(low<=high){
            int pivot = low + ((high-low)/2);
            if(nums[pivot]<=nums[min]){
                min=pivot;
                high = pivot-1;
            }
            else{
                low = pivot +1;
            }
            
        }
        return nums[min];
    }
}