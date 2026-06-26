// Last updated: 6/26/2026, 8:54:54 AM
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int l=0,r=0;
        if(nums.size()==0)return 0;
        int temp_ans=0;
        int ans=INT_MAX;
        while(r<nums.size()){
            temp_ans+=nums[r];
            if(temp_ans < target){
                r++;
            }
            else if(temp_ans>= target){
                while(temp_ans >= target){
                    ans=min(ans,r+1-l);
                 temp_ans-=nums[l];
                    l++;
                }
                r++;
            }
            
            
        }
        if(ans==INT_MAX)return 0;
        else return ans;
    }
};