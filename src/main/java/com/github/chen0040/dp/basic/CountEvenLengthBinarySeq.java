package com.github.chen0040.dp.basic;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 13/9/2017.
 *
 * link: http://www.geeksforgeeks.org/count-even-length-binary-sequences-with-same-sum-of-first-and-second-half-bits/
 */
public class CountEvenLengthBinarySeq {
   public static int countSeqRecursive(int n) {
      return countSeqRecursive(n, 0);
   }

   private static int countSeqRecursive(int n, int diff) {
      if(Math.abs(diff) > n) return 0;
      if(n == 1) {
         if(Math.abs(diff) == 0) return 2;
         if(Math.abs(diff) == 1) return 1;
      }
      return countSeqRecursive(n-1, diff+1) + // first bit is 1 and last bit is 0
              countSeqRecursive(n-1, diff-1) + // first bit is 0 and last bit is 1
              countSeqRecursive(n-1, diff) * 2; // first bit and last bit are the same

   }

   public static int countSeqDP(int n) {
      return countSeqDP(n, 0, new HashMap<>());
   }

   private static int countSeqDP(int n, int diff, Map<String, Integer> lookup) {
      String key = n + "_" + diff;

      if(Math.abs(diff) > n) return 0;
      if(n == 1) {
         if(Math.abs(diff) == 0) return 2;
         if(Math.abs(diff) == 1) return 1;
      }

      if(lookup.containsKey(key)) {
         return lookup.get(key);
      }

      int res = countSeqDP(n-1, diff+1, lookup) + // first bit is 1 and last bit is 0
         countSeqDP(n-1, diff-1, lookup) + // first bit is 0 and last bit is 1
         countSeqDP(n-1, diff, lookup) * 2; // first bit and last bit are the same

      lookup.put(key, res);
      return res;

   }

   public static void main(String[] args) {
      System.out.println("count of even length sequences is " + countSeqDP(2));
   }
}
