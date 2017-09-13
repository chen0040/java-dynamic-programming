package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 12/9/2017.
 *
 * link: http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
 */
public class WaysToReachGameScore {
   public static int countWaysRecursive(int[] S, int score) {
      return countWaysRecursive(S, score, S.length-1);
   }

   private static int countWaysRecursive(int[] S, int score, int i) {
      // base case
      if(score == 0) return 1;

      if(score < 0) return 0;

      if(i == 0) {
         if(score % S[i] == 0) return 1;
         else return 0;
      }

      if(i < 0 && score > 0) return 0;

      return countWaysRecursive(S, score-S[i], i) + // number of solutions containing at least one S[i]
              countWaysRecursive(S, score, i-1); // number of solutions not containing S[i]
   }

   public static int countWaysDP(int[] S, int score) {
      int n = S.length;
      int[][] ways = new int[score+1][n];

      // if score is 0, then there is only one way
      for(int i=0; i < n; ++i) {
         ways[0][i] = 1;
      }

      for(int i=1; i <= score; ++i) {
         for(int j=0; j < n; ++j) {
            if(i < S[j]) {
               if(j > 0)
                  ways[i][j] = ways[i][j-1];
               continue;
            }
            if(j == 0) {
               ways[i][j] = ways[i - S[j]][j];
            } else {
               ways[i][j] = ways[i - S[j]][j] + ways[i][j - 1];
            }

         }
      }
      return ways[score][n-1];
   }

   public static void main(String[] args) {
      int n = 20;
      System.out.println("Count for " + n + " is " + countWaysDP(new int[]{3, 5, 10}, n));
      n = 13;
      System.out.println("Count for " + n + " is " + countWaysDP(new int[]{3, 5, 10}, n));
   }
}
