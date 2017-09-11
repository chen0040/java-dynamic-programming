package com.github.chen0040.dp;


/**
 * Created by xschen on 4/9/2017.
 *
 * link: http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {
   // Returns true if there is a subset of set[] with sun equal to given sum
   public static boolean isSubsetSumRecursive(int[] set, int n, int sum) {

      // base case
      if(sum == 0) return true;

      if(n == 0 && sum != 0) return false;

      // if last element is greater than sum, ignore it
      if(set[n-1] > sum) return isSubsetSumRecursive(set, n-1, sum);

      return isSubsetSumRecursive(set, n-1, sum) // solution that do not include set[n-1]
         || isSubsetSumRecursive(set, n-1, sum - set[n-1]); // solution that include set[n-1]
   }

   // Returns true if there is a subset of set[] with sun equal to given sum
   public static boolean isSubsetSumDP(int[] set, int n, int sum) {
      boolean[][] dp = new boolean[n+1][sum+1];
      for(int i=0; i < n; ++i) {
         dp[i][0] = true;
      }

      for(int i=1; i <= n; ++i) {
         for(int j=1; j <= sum; ++j) {
            if(set[i-1] > j) { // if last element is greater than sum, ignore it
               dp[i][j] = dp[i-1][j];
            } else {
               dp[i][j] = dp[i-1][j] || // solution that do not include set[n-1]
                       dp[i-1][j - set[i-1]]; // solution that include set[n-1]
            }
         }
      }

      return dp[n][sum];
   }

   public static void main(String[] args) {
      int set[] = {1,2,3};
      int sum = 7;
      int n = set.length;
      if (isSubsetSumDP(set, n, sum))
         System.out.println("Found a subset with given sum");
      else
         System.out.println("No subset with given sum");

      set = new int[]{3, 34, 4, 12, 5, 2};
      sum = 9;
      n = set.length;
      if (isSubsetSumDP(set, n, sum) == true)
         System.out.println("Found a subset with given sum");
      else
         System.out.println("No subset with given sum");
   }
}
