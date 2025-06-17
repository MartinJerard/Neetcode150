package neetcode150.medium;

//Link https://leetcode.com/problems/3sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
           List<List<Integer>> ans = new ArrayList<>();
           Arrays.sort(nums);
           for(int i=0; i<nums.length-2;i++){
               int j = i+1;
               int k = nums.length-1;
               if((i>=1) && (nums[i]==nums[i-1]))
                   continue;
               while(j<k){
                   if(nums[i]+nums[j]+nums[k] == 0){
                       ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                       j++;
                       while((j<=k)&&(nums[j]==nums[j-1])){
                           j++;
                       }
                   }
                   else if(nums[i]+nums[j]+nums[k] < 0){
                       j++;
                   }
                   else if(nums[i]+nums[j]+nums[k] > 0){
                        k--;
                   }
               }
           }
    return ans;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(new int[]{-10, -5, -5, -4, -4, -3, -2, -2, 0, 0, 1, 2, 2, 2, 2, 5, 5});
        System.out.println(result); // Output: [1, 2]
    }
}
