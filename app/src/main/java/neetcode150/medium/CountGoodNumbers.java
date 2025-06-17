package neetcode150.medium;

//Link https://leetcode.com/problems/count-good-numbers/
import java.util.Arrays;
import java.util.HashMap;

public class CountGoodNumbers {
    private final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int) (myPow(5, (n + 1) / 2) * myPow(4, n / 2) % MOD);
    }

    private long myPow(long base, long exponent) {
        long result = 1; 
        base = base % MOD;
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1; 
        }
        return result;
    }

    public static void main(String[] args) {
        CountGoodNumbers solution = new CountGoodNumbers();
        int result = solution.countGoodNumbers(50);
        System.out.println(result); // Output: 564908303
    }
}
