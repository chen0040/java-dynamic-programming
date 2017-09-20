package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 20/9/2017.
 *
 * link: http://www.geeksforgeeks.org/space-optimized-solution-lcs/
 */
public class LongestCommonSubsequenceII {

   public static int lcs(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int[][] L = new int[2][n+1];

      int bi = 0;
      for(int i=0; i <= m; ++i) {
         bi = i & 1;

         for(int j=0; j <= n; ++j) {
            if(i == 0 || j == 0) L[bi][j] = 0;
            else if(s1.charAt(i-1) == s2.charAt(j-1)) {
               L[bi][j] = 1 + L[1-bi][j-1];
            }
            else {
               L[bi][j] = Math.max(L[1-bi][j], L[bi][j-1]);
            }
         }
      }

      return L[bi][n];
   }

   public static void main(String[] args) {
      String X = "AGGTAB";
      String Y = "GXTXAYB";

      System.out.println("Length of LCS is " + lcs(X, Y));
   }

}
