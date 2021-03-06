class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        int ans = f(coins,amount,dp);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public int f(int[] coins, int amount,int[] dp){
        if(amount==0) return 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<coins.length;i++){
            
            if(amount-coins[i] >= 0){
                int subans=0;
                if(dp[amount-coins[i]] != -1){
                 subans = dp[amount-coins[i]];
            }else{
                 subans = f(coins,amount-coins[i],dp);
                 }
            if(subans != Integer.MAX_VALUE && subans+1 < ans){
                ans = subans+1;
              }
            }
        }
       
        return dp[amount] = ans;
    }
}