package com.github.chen0040.dp;


/**
 * Created by xschen on 4/9/2017.
 *
 * link: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *  Insert
 *  Remove
 *  Replace
 */
public class EditDistance {
   public static int editDistanceRecursive(String s1, String s2, int m, int n) {
      // if first string is empty, the only option is to insert all characters of second string into first
      if(m == 0) return n;
      // if second string is empty, the only option is to remove all characters of first string
      if(n == 0) return m;

      // if last characters are the same, nothing much to do, ignore last characters and get count for remaining strings
      if(s1.charAt(m-1) == s2.charAt(n-1))
         return editDistanceRecursive(s1, s2, m-1, n-1);

      return 1 + min(editDistanceRecursive(s1, s2, m, n-1), // Insert
               editDistanceRecursive(s1, s2, m-1, n), // Remove
               editDistanceRecursive(s1, s2, m-1, n-1)// Replace
              );
   }

   public static int editDistanceDP(String s1, String s2, int m, int n) {
      int[][] dp = new int[m+1][n+1];
      for(int i=0; i <= m; ++i) {
         for(int j=0; j <= n; ++j) {
            // if first string is empty, the only option is to insert all characters of second string into first
            if(i == 0) dp[i][j] = j;
            // if second string is empty, the only option is to insert all characters of first string into second
            else if(j == 0) dp[i][j] = i;
            // if last characters are the same, ignore last characters and get count for remaining strings
            else if(s1.charAt(i-1) == s2.charAt(j-1)) {
               dp[i][j] = dp[i-1][j-1];
            }
            else {
               dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                       dp[i - 1][j], // Remove
                       dp[i - 1][j - 1] // Replace
               );
            }
         }
      }
      return dp[m][n];
   }

   private static int min(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
   }

   public static void main(String[] args) {
      String str1 = "sunday";
      String str2 = "saturday";
      System.out.println(editDistanceDP(str1, str2, str1.length(), str2.length()));
      System.out.println(editDistanceRecursive(str1, str2, str1.length(), str2.length()));
   }
}
