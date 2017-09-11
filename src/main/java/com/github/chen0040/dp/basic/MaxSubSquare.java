package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 4/9/2017.
 *
 * link: http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 *
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 */
public class MaxSubSquare {
   private static int min(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
   }
   public static void printMaxSubSquare(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] S = new int[m][n];

      for(int i=0; i < m; ++i) {
         S[i][0] = matrix[i][0];
      }
      for(int i=0; i < n; ++i) {
         S[0][i] = matrix[0][i];
      }
      for(int i=1; i < m; ++i) {
         for(int j=1; j < n; ++j) {
            if(matrix[i][j] == 1) {
               S[i][j] = 1 + min(S[i-1][j], S[i-1][j-1], S[i][j-1]);
            } else {
               S[i][j] = 0;
            }
         }
      }

      int maxSize = 0;
      int square_i = -1;
      int square_j = -1;
      for(int i=0; i < m; ++i) {
         for(int j=0; j < n; ++j) {
            if(S[i][j] > maxSize) {
               square_i = i;
               square_j = j;
               maxSize = S[i][j];
            }
         }
      }

      for(int i=square_i-maxSize+1; i <= square_i; ++i) {
         for(int j=square_j-maxSize+1; j <= square_j; ++j) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static void main(String[] args)
   {
      int M[][] =  {{0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 0},
              {1, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {0, 0, 0, 0, 0}};

      printMaxSubSquare(M);
   }
}
