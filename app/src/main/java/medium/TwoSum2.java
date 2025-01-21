package main.java.medium;

//Link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=problem-list-v2&envId=plakya4j
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {

        // Approach 1: Using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff)+1, i+1};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum2 solution = new TwoSum2();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}
