package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// Link https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08

public class MinimumIncrementToMakeArrayUnique {
    public int minimumOperations(int[] nums) {
        // Approach 1: Using Hashset
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return i/3 +1;
            }
            set.add(nums[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();
        int result = solution.minimumOperations(new int[]{8,8,11,8});
        System.out.println(result);     // Output: true
    }
}
