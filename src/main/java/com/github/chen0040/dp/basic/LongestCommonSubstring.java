package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 12/9/2017.
 *
 * link: http://www.geeksforgeeks.org/longest-common-substring/
 */
public class LongestCommonSubstring {
   public static int maxLen(String s1, String s2) {
      int len1 = s1.length();
      int len2 = s2.length();

      int[][] maxLens = new int[len1][len2];

      int result = 0;
      for(int i=0; i < len1; ++i) {
         char c1 = s1.charAt(i);
         for(int j=0; j < len2; ++j) {
            char c2 = s2.charAt(j);
            if(c1 == c2) {
               maxLens[i][j] = maxLens[i-1][j-1] + 1;
               result = Math.max(result, maxLens[i][j]);
            } else {
               maxLens[i][j] = 0;
            }
         }
      }

      return result;
   }

   public static void main(String[] args)
   {
      String s1 = "OldSite:GeeksforGeeks.org";
      String s2 = "NewSite:GeeksQuiz.com";
      System.out.println("Length of Longest Common Substring is " + maxLen(s1, s2));
   }
}
