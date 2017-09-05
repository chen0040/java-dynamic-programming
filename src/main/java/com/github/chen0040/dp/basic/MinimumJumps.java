package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 5/9/2017.
 *
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 *
 * Example:
 *
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 */
public class MinimumJumps {
   // Returns minimum number of jumps to reach arr[h] from arr[l]
   public static int minJumpsRecursive(int arr[], int l, int h) {
      // base case: when source and destination are same
      if(l == h) return 0;

      // when nothing is reachable from the given source
      if(arr[l] == 0) return Integer.MAX_VALUE;

      // Traverse through all the points reachable from arr[l]. Recursively
      // get the minimum number of jumps needed to reach arr[h] from these
      // reachable points
      int min = Integer.MAX_VALUE;
      for(int i=l+1; i <= h && i <= l + arr[l]; ++i) {
         int jumps = minJumpsRecursive(arr, i, h);
         if(jumps != Integer.MAX_VALUE && jumps+1 < min) {
            min = jumps + 1;
         }
      }

      return min;
   }

   // Returns minimum number of jumps to reach arr[n-1] from arr[0]
   public static int minJumpsDP(int arr[], int n)
   {
      int[] jumps = new int[n]; // jumps[n-1] will hold the result
      int i, j;

      if(n==0 || arr[0] == 0) return Integer.MAX_VALUE;

      jumps[0] = 0;

      // Find the minimum number of jumps to reach arr[i] from
      // arr[0], and assign this value to jumps[i]
      for(i = 1; i < n; ++i) {
         jumps[i] = Integer.MAX_VALUE;
         for(j = 0; j < i; j++) {
            if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
               jumps[i] = Math.min(jumps[i], jumps[j] + 1);
            }
         }
      }
      return jumps[n-1];
   }

   // Driver program to test above function
   public static void main(String[] args)
   {
      int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
      int n = arr.length;
      System.out.println("Minimum number of jumps to reach end is " + minJumpsRecursive(arr, 0, n-1));
      System.out.println("Minimum number of jumps to reach end is " + minJumpsDP(arr, n));
   }
}
