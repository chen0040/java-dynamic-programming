package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * Following are common definition of Binomial Coefficients.
 * 1) A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 *
 * 2) A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.
 */
public class BinomialCoefficient {

   public static int C_Recursive(int n, int k) {
      if(k == 0 || k == n) return 1;
      return C_Recursive(n-1, k-1) + // solutions which contains number n
         C_Recursive(n-1, k); // solutions which do not contains number n
   }

   public static int C_DP(int n, int k) {
      int[][] dp = new int[n+1][k+1];
      for(int i=0; i <= n; i++) {
         for(int j=0; j <= Math.min(i, k); ++j) {
            if(j==0 || j == i) {
               dp[i][j] = 1;
            } else {
               dp[i][j] = dp[i - 1][j - 1] + // solution which contains number i
                       dp[i - 1][j]; // solution which do not contains number i
            }
         }
      }

      return dp[n][k];
   }

   /* Driver program to test above function*/
   public static void main(String args[])
   {
      int n = 5, k = 2;
      System.out.println("Value of C("+n+","+k+") is "+C_DP(n, k));
   }


}
