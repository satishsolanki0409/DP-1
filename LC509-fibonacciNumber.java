class Solution {
    public int fib(int n) {
        // F(n) = f(n-1) + f(n-2)
        
        if (n<2) return n;

        int prev = 0;
        int cur = 1; // f(1)
        
        while(n>=2) {
            cur = cur + prev;
            prev = cur - prev;
            n--;
        }
        
        return cur;
    }
}