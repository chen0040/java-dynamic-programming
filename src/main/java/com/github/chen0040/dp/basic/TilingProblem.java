package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 13/9/2017.
 */
public class TilingProblem {
   public static int countWays(int n) {
      if(n == 1 || n == 2) {
         return n;
      }
      return countWays(n-1) + // place next one vertically
         countWays(n-2); // place next two horizontally
   }
}
