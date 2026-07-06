// Last updated: 7/6/2026, 6:55:58 PM
class Solution {

    int[] coins;

    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        int[][] dp = new int[coins.length +1][amount+1];

        for(int j=1; j <= amount; j++) {
            dp[coins.length][j] = Integer.MAX_VALUE;
        }

        for(int i=coins.length-1; i>=0; i--) {
            for(int j=0; j<=amount; j++) {

                int skip = dp[i+1][j];

                int take = Integer.MAX_VALUE;

                if(coins[i] <= j && dp[i][j-coins[i]] != Integer.MAX_VALUE) {
                    take = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(skip, take);
            }
        }

        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
        
    }

    public int helper(int remainingAmount) {

        if(remainingAmount == 0) return 0;

        int take = Integer.MAX_VALUE;

        for(int coin : coins) {

            if(coin <= remainingAmount) {
               int res = helper(remainingAmount-coin);
               if(res != Integer.MAX_VALUE)
               take = Math.min(take, 1 + helper(remainingAmount-coin));
            }
        }

        return take;
    }

    public int helperRec(int i, int remainingAmount) {

        if(remainingAmount == 0) return 0;

        if(i >= coins.length) return Integer.MAX_VALUE;


        int skip = helperRec(i+1, remainingAmount);

        int take = Integer.MAX_VALUE;

        if(coins[i] <= remainingAmount) {
            int res = helperRec(i,remainingAmount-coins[i]);
            if(res != Integer.MAX_VALUE)
            take = 1 + res;
        }

        return Math.min(skip, take);
    }

    

}