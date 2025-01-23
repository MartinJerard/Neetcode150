package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;

// Link https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=plakya4j
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // Approach 1: Using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}
