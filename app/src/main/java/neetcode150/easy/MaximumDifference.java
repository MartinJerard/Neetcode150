package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;

// Link https://leetcode.com/problems/maximum-difference-between-increasing-elements/?envType=daily-question&envId=2025-06-16
public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        int first, second = 0;
        int ans = -1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                first = nums[i-1];
                for(int j=i;j<nums.length;j++){
                    if(nums[j]> second){
                        second = nums[j];
                    }  
                    else if (nums[j]< first){
                        first = nums[j];
                        second = nums[j];
                    }                  
                    ans = Math.max(ans,second - first);
                }
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumDifference solution = new MaximumDifference();
        int result = solution.maximumDifference(new int[]{7,1,5,4});
        System.out.println(result); // Output: 4
    }
}
