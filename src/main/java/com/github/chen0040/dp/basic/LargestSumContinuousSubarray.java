package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class LargestSumContinuousSubarray {
   public static int maxSubArraySum(int[] a) {
      int max_sum = Integer.MIN_VALUE;
      int sum_so_far = 0;
      for(int i=0; i < a.length; ++i) {
         int num = a[i];
         sum_so_far += num;
         if(sum_so_far < 0) {
            sum_so_far = 0;
         } else if(sum_so_far > max_sum){
            max_sum = sum_so_far;
         }
      }
      return max_sum;
   }

   public static void main (String[] args)
   {
      int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
      System.out.println("Maximum contiguous sum is " +
              maxSubArraySum(a));
   }
}
