package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;

// Link https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/
public class MinSumMountain {
    public int minimumSum(int[] nums) {
        final int inf = 1 << 30;
        int ans =  inf;
        for(int i=1; i<nums.length-1;i++){
            int minLeft = minArray(nums,0,i);
            int minRight = minArray(nums,i+1, nums.length);
            if((nums[i] > minLeft) && (minRight < nums[i]))
                ans = Math.min(ans, nums[i] + minLeft + minRight);
        }
        return ans== inf? -1: ans;
    }

    public int minArray( int[] array, int start, int end){
        int min = array[start];
        for(int i=start; i < end; i++){
            min = Math.min(min, array[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinSumMountain solution = new MinSumMountain();
        int result = solution.minimumSum(new int[]{8,6,1,5,3});
        System.out.println(result); // Output: 9
    }
}
