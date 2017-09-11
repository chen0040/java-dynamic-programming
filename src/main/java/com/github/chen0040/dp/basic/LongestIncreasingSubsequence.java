package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 *
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 *
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 */
public class LongestIncreasingSubsequence {
   private static int longestLength;


   private static int _lis_recursive(int arr[], int n) {
      // base case
      if(n==1) return 1;

      // 'max_ending_here' is length of LIS ending with arr[n-1]
      int res, max_ending_here = 1;

      // Recursively get all LIS ending with arr[0], arr[1] ...
      // arr[n-2]. If arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1]
      // needs to be updated, then update it
      for(int i=1; i < n; ++i) {
         res = _lis_recursive(arr, i);
         if(arr[i-1] < arr[n-1] && res + 1 > max_ending_here) {
            max_ending_here = res + 1;
         }
      }

      // Compare max_ending_here with the overall max,
      // and update the overall max if needed
      if(longestLength < max_ending_here) {
         longestLength = max_ending_here;
      }

      return max_ending_here;
   }

   /* lis() returns the length of the longest increasing
       subsequence in arr[] of size n */
   public static int lis_recursive(int arr[], int n) {
      longestLength = 1;
      _lis_recursive(arr, n);
      return longestLength;
   }

   public static int lis_dp(int arr[], int n) {
      int lis[] = new int[n];
      int i, j, max = 0;

      for(i=0; i < n; ++i) {
         lis[i] = 1;
      }

      // compute optimized LIS values in bottom up manner
      for(i=1; i < n; ++i) {
         for(j = 0; j < i; ++j) {
            if(arr[j] < arr[i] && lis[j]+1 > lis[i]) {
               lis[i] = lis[j] + 1;
            }
         }
      }

      longestLength = 1;
      // Pick maximum of all LIS values
      for(i=0; i < n; ++i) {
         if(longestLength < lis[i]) {
            longestLength = lis[i];
         }
      }
      return longestLength;
   }

   // driver program to test above functions
   public static void main(String args[])
   {
      int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
      int n = arr.length;
      System.out.println("Length of lis is "
              + lis_dp(arr, n));
   }

}
