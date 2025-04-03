package neetcode150.medium;

//Link https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/?envType=daily-question&envId=2025-04-03
import java.util.Arrays;
import java.util.HashMap;

public class MaxValueTripletII {
    public long maximumTripletValue(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        long ans = 0;
        long max_diff=0;
        int max=0;
        for(int n:nums){
            ans = (long) Math.max(ans, max_diff*n);
            max_diff = (long) Math.max(max_diff, max - n);
            max = Math.max(max, n);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        MaxValueTripletII solution = new MaxValueTripletII();
        long result = solution.maximumTripletValue(new int[]{6,11,12,12,7,9,2,11,12,4,19,14,16,8,16});
        System.out.println(result); // Output: 77
    }
}
