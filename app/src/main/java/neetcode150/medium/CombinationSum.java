package neetcode150.medium;

//Link https://leetcode.com/problems/3sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> combinations = new ArrayList<>();
    private List<Integer> currentCombination = new ArrayList<>();
    private int[] values;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.values = candidates;
        dfs(0, target);
        return combinations;
    }

    public void dfs (int start, int rem_sum){
        if(rem_sum == 0){
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        if(start>= values.length || values[start] > rem_sum){
            return;
        }
        dfs(start+1, rem_sum);

        currentCombination.add(values[start]);
        dfs(start, rem_sum-values[start]);

        currentCombination.removeLast();
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(result); // Output: [1, 2]
    }
}
