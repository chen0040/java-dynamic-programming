package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
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
