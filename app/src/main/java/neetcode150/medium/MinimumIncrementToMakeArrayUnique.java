package neetcode150.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// Link https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

public class MinimumIncrementToMakeArrayUnique {
    public int minimumOperations(int[] nums) {
        int increment = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                increment += nums[i - 1] - nums[i] + 1;
                // Increment the current number to make it unique
                nums[i] = nums[i - 1] + 1;
            }
        }
        return increment;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();
        int result = solution.minimumOperations(new int[]{8,8,11,8});
        System.out.println(result);     // Output: true
    }
}
