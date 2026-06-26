// Last updated: 6/26/2026, 8:55:24 AM
class Solution {
    public int maxArea(int[] height) {
        int final_area=0;
        int l=0;
        int r=height.length-1;
        while(l<=r){
            final_area = Math.max(final_area,(r-l)*(Math.min(height[l],height[r])));
            if(height[l]<height[r])l++;
            else r--;
        }
        return final_area;
    }
}