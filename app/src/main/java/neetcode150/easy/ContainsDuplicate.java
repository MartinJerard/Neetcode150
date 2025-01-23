package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// Link https://leetcode.com/problems/contains-duplicate/description/

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Approach 1: Using Hashset
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (map.contains(num)) {
                return true;
            }
            map.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result = solution.containsDuplicate(new int[]{1,2,3,1});
        System.out.println(result);     // Output: true
    }
}
