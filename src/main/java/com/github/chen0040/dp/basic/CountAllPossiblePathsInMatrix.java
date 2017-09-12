package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 12/9/2017.
 *
 * link: http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
public class CountAllPossiblePathsInMatrix {
   public static int pathsRecursive(int m, int n) {
      if(m == 0 || n == 0) return 1;
      return pathsRecursive( m, n-1) + pathsRecursive(m-1, n);
   }

   public static int pathsDP(int m, int n) {
      int[][] dp =new int[m][n];
      for(int i=0; i < m; ++i) {
         dp[i][0] = 1;
      }
      for(int i=0; i < n; ++i) {
         dp[0][i] = 1;
      }
      for(int i=1; i < m; ++i) {
         for(int j=1; j < n; ++j) {
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
         }
      }
      return dp[m-1][n-1];
   }

   public static void main(String[] args) {
      System.out.println(pathsDP(3, 3));
   }
}
