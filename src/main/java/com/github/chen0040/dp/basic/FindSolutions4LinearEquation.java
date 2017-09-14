package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 14/9/2017.
 *
 * link: http://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
 */
public class FindSolutions4LinearEquation {

   public static int findSolutions(int[] coef, int rhs) {
      return findSolutions(coef, 0, coef.length-1, rhs);
   }

   private static int findSolutions(int[] coef, int start, int end, int rhs) {
      if(rhs == 0) return 1;

      int res = 0;
      for(int i=start; i <= end; ++i) {
         if(coef[i] <= rhs) {
            res += findSolutions(coef, i, end, rhs - coef[i]);
         }
      }
      return res;
   }

   private static int findSolutionsDP(int[] coef, int rhs) {
      int n = coef.length;
      int[] ways = new int[rhs+1];

      ways[0] = 1;
      for(int i=0; i < n; ++i) {
         for(int j=coef[i]; j <= rhs; ++j) {
            ways[j] += ways[j-coef[i]];
         }
      }

      return ways[rhs];
   }

   public static void main(String[] args) {
      int coeff[]  = {2, 2, 5};
      int rhs = 4;
      System.out.println(findSolutionsDP(coeff, rhs));
   }
}
