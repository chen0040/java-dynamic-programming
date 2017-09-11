package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 11/9/2017.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 *
 */
public class MaxSumIncreasingSequence {
   public static int maxSum(int[] arr) {
      int n = arr.length;
      int[] maxSums = new int[n];

       /* Initialize maxSums values for all indexes */
      for (int i = 0; i < n; i++ ) {
         maxSums[i] = arr[i];
      }

      for(int i=1; i < n; ++i) {
         for(int j=0; j < i; ++j) {
            if(arr[j] < arr[i] && maxSums[i] < maxSums[j] + arr[i]) {
               maxSums[i] = maxSums[j] + arr[i];
            }
         }
      }

      int max = 0;
      for(int i=0; i < n; ++i) {
         max = Math.max(maxSums[i], max);
      }

      return max;
   }

   public static void main(String[] args) {
      int arr[] = {1, 101, 2, 3, 100, 4, 5};
      System.out.println("Sum of maximum sum increasing subsequence is " +
              maxSum( arr) );
   }
}
