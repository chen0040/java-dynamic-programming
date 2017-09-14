package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 14/9/2017.
 *
 * link: http://www.geeksforgeeks.org/compute-ncr-p-set-1-introduction-and-dynamic-programming-solution/
 */
public class ComputeCnrModP {
   public static int nCrModp(int n, int r, int p) {
      int[][] Cr = new int[n+1][r+1];

      for(int i=0; i <= n; ++i) {
         Cr[i][0] = 1;
      }
      for(int i=1; i <=n ; ++i) {
         for(int j=1; j <= r; ++j) {
            if(i < j) continue;
            if(i == j) {
               Cr[i][j] = 1;
            } else {
               Cr[i][j] = (Cr[i-1][j] + Cr[i-1][j-1]);
            }
         }
      }
      return Cr[n][r]  % p;
   }

   public static void main(String[] args) {
      int n = 10, r = 2, p = 13;
      System.out.println("Value of nCr % p is " + nCrModp(n, r, p));
   }
}
