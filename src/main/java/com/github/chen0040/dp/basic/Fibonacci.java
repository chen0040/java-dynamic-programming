package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * link: http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * The Fibonacci numbers are the numbers in the following integer sequence.
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 *
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 *
 * Fn = Fn-1 + Fn-2
 *
 * with seed values
 *
 * F0 = 0 and F1 = 1.
 */
public class Fibonacci {
   public static int fibonacci(int n) {
      int[] F = new int[n+1];
      F[0] = 0;
      F[1] = 1;
      for(int i = 2; i <= n; ++i) {
         F[i] = F[i-2] + F[i-1];
      }
      return F[n];
   }

   public static void main (String args[])
   {
      int n = 9;
      System.out.println(fibonacci(n));
   }

}
