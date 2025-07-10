package neetcode150.medium;

//Link https://leetcode.com/problems/3sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private List<List<Integer>> combinations = new ArrayList<>();
    private List<Integer> currentCombination = new ArrayList<>();
    private int[] values;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        currentCombination.add(values[start]);
        dfs(start+1, rem_sum-values[start]);
        currentCombination.removeLast();

        while (start + 1 < values.length && values[start] == values[start + 1]) {
            start++;
        }
        dfs(start+1, rem_sum);
    }

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> result = solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(result); // Output: [1, 2]
    }
}
