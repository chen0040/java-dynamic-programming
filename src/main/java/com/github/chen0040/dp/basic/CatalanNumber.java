package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 12/9/2017.
 *
 * link: http://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class CatalanNumber {
   public static int count(int n) {
      if(n <= 1) return 1;
      int[] C = new int[n + 1];
      C[0] = 1;
      C[1] = 1;

      for(int i=1; i < n; ++i) {
         C[i+1] = 0;
         for(int j=0; j <= i; ++j) {
            C[i+1] += C[j] * C[i-j];
         }
      }

      return C[n];
   }

   public static void main(String[] args) {
      for(int i=0; i < 10; ++i) {
         System.out.println("catalan(" + i + "): " + count(i));
      }
   }
}
