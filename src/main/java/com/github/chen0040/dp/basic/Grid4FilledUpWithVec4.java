package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 20/9/2017.
 *
 * link: http://www.geeksforgeeks.org/count-number-of-ways-to-fill-a-n-x-4-grid-using-1-x-4-tiles/
 */
public class Grid4FilledUpWithVec4 {
   public static int countRecursive(int n) {
      if(n == 4) return 2;
      if(n < 4) return 1;
      return countRecursive(n-1) + // place one horizontally
      + countRecursive(n-4);
   }

   public static void main(String[] args)
   {
      int n = 5;
      System.out.println("Count of ways is " + countRecursive(n));
   }
}
