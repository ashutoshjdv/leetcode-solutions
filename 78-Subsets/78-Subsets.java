// Last updated: 6/26/2026, 8:55:13 AM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      
        List<List<Integer>> result=new ArrayList();
        subsetgen(result,new ArrayList(),0,nums);
        return result;
    }
    static void subsetgen(List<List<Integer>> result,List<Integer> subset, int l,int nums[]){
        if(l>nums.length)return;
        if(l>=nums.length){
            result.add(new ArrayList<>(subset));
        }
        if(l<nums.length){
        subset.add(nums[l]);
        subsetgen(result,subset,l+1,nums);
        subset.remove(subset.size()-1);
        
        subsetgen(result,subset,l+1,nums);
        }
        
    }
}