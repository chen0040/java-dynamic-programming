package com.github.chen0040.dp.basic;


/**
 * Created by xschen on 11/9/2017.
 */
public class MaxChainOfPairs {
   private static class Tuple {
      public int a;
      public int b;
      public Tuple(int a, int b) {
         this.a = a;
         this.b = b;
      }
   }

   public static int maxChainLength(Tuple[] pairs) {
      int n = pairs.length;
      int[] mcl = new int[n];
      for(int i=0; i < n; ++i) {
         mcl[i] = 1;
      }

      for(int i=1; i < n; ++i) {
         for(int j=0; j < i; ++j) {
            if(pairs[j].b < pairs[i].a && mcl[i] < mcl[j] + 1) {
               mcl[i] = mcl[j] + 1;
            }
         }
      }

      int max = 0;
      for(int i=0; i < n; ++i) {
         max = Math.max(mcl[i], max);
      }
      return max;
   }

   public static void main(String[] args) {
      Tuple[] arr = { new Tuple(5, 24), new Tuple(15, 25),
         new Tuple(27, 40), new Tuple(50, 60) };
      System.out.println("Length of maximum size chain is " +
              maxChainLength( arr));
   }
}
