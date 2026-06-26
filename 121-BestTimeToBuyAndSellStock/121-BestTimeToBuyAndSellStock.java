// Last updated: 6/26/2026, 8:55:06 AM
class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,max=0,res=0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                max=0;
            }
            if(prices[i]>max){
                max=prices[i];
            }
            if((max-min)>res){
                res=max-min;
            }
        }
        return res;
    }
}