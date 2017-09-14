package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 14/9/2017.
 *
 * link: http://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/
 */
public class WaysOfPartitioning {
   public static int bellNumber(int n, int k) {
      int[][] ways = new int[n+1][k+1];
      ways[0][0]=1;
      for(int i=1; i <= n; ++i) {
         ways[i][0] = ways[i-1][i-1];
         for(int j=1; j <= i; ++j) {
            ways[i][j] = ways[i][j-1] + ways[i-1][j-1];
         }
      }

      return ways[n][0];
   }

   public static void main(String[] args) {
      for (int n=0; n<=5; n++)
         System.out.println("Bell Number " + n + " is "
                 + bellNumber(n, n));
   }
}
