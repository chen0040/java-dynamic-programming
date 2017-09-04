package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * CS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 *
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.
 *
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSequence {

   /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
   public static int lcs_recursive(String s1, String s2, int m, int n) {
      if(m <= 0) return 0;
      if(n <= 0) return 0;
      if(s1.charAt(m-1) == s2.charAt(n-1)) {
         return lcs_recursive(s1, s2, m-1, n-1) + 1;
      }
      return Math.max(lcs_recursive(s1, s2, m-1, n), lcs_recursive(s1, s2, m, n-1));
   }

   public static int lcs_dp(String s1, String s2, int m, int n) {
      int[][] dp = new int[m+1][n+1];
      for(int i=1; i <= m; ++i) {
         for(int j=1; j <= n; ++j) {
            if(s1.charAt(i-1) == s2.charAt(j-1)){
               dp[i][j] = 1 + dp[i-1][j-1];
            } else {
               dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
         }
      }
      return dp[m][n];
   }

   public static void main(String[] args)
   {
      String s1 = "AGGTAB";
      String s2 = "GXTXAYB";

      int m = s1.length();
      int n = s2.length();

      System.out.println("Length of LCS is" + " " +
              lcs_dp( s1, s2, m, n ) );
   }

}
