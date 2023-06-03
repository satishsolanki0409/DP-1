// Method-2 : using DP 
/*
                    count
  0 -> 000000 =      0 
  
  1 -> 000001 =      1 = 1 + count(1-1) offset =1

  2 -> 000010 =      1 = 1 + count(2-2) offset = 2
  3 -> 000011 =      2 = 1 + count(3-2)

  4 -> 0001 00 =  1 + count(0) = 1 + count(4-4) offset = 4
  5 -> 0001 01 = 1 + count(1) = 1 + count(5-4)
  6 -> 0001 10 = 1 + count(2) = 1 + count(6-4)
  7 -> 0001 11 = 1 + count(3) = 1 + count(7-4)

  8 -> 001 000 = 1 + count(0)= 1 + count(8-8) offset = 8
  9 -> 001 001 = 1+ count(1) = 1 + count(9-8)
  
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        int offset = 1;
        
        for (int i=1; i<=n; i++) {
            if (i==offset*2) offset *= 2;
            dp[i] = 1 + dp[i-offset];
        }
  
        return dp;
    }
}


// Method-1 : brute force
class Solutio1 {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        
        ret[0] = 0;
        
        for (int i=1; i<=n; i++) { // O(nlog(n))
            ret[i] = countOnes(i);// O(log(n))
        }
        
        return ret;
    }
    
    // count 1's in binary
    public int countOnes(int n) { // O(log(n))
        int ans = 0;
        while(n>0) {
            ans += (n%2); // add count of least significant bit
            n = n/2; // this will sift the binary right by 1 bit Example : 6/2=3 (110 -> 11)
        }
        
        return ans;
    }
}