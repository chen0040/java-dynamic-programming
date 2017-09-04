package com.github.chen0040.dp;


/**
 * Created by xschen on 4/9/2017.
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

   // Returns the count of ways we can sum S[0...m-1] coins to get sum n
   public static int countRecursive(int[] S,  int m, int n) {
      // if n is 0 then there is 1 solution (do not include any coin)
      if(n == 0) return 1;

      // if n is less than 0 then no solution exists
      if(n < 0) return 0;

      // iIf there are no coins and n is greater than 0, then no solution exists
      if(m <= 0 && n > 0)  return 0;

      return countRecursive(S, m-1, n) // number of ways to get sum n not including coin S[m] => solutions that do not contain coin S[m]
         + countRecursive(S, m, n - S[m-1]); // number of ways to get sum n-S[m] => solutions that include at least one coin S[m]
   }

   // Returns the count of ways we can sum S[0...m-1] coins to get sum n
   public static int countDP(int[] S, int m, int n) {
      int[][] dp = new int[m][n+1];
      for(int i=0; i < m; ++i) {
         dp[i][0] = 1;
      }

      for(int i=0; i < m; ++i) {
         for(int j=1; j <= n; ++j) {

            // solutions that include at least one coin S[i]
            int x = j-S[i] < 0 ? 0 : dp[i][j - S[i]];

            // solutions that do not include coin S[i]
            int y = i < 1 ? 0 : dp[i-1][j];

            dp[i][j] = x + y;
         }
      }

      return dp[m-1][n];
   }

   public static void main(String[] args){
      int arr[] = {1, 3, 2};
      int m = arr.length;
      int n = 4;
      System.out.println(countDP(arr, m, n));
   }
}
