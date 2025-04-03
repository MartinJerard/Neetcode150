package neetcode150.medium;

//Link https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?utm_source=instabyte.io&utm_medium=newsletter&utm_campaign=amazon-launched-a-new-ai-agent&_bhlid=1c099fcd828f0fdbc40d1f1d2e9c86f49a7f2c9e
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class ZigZagBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int size = queue.size();
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (currentLevel % 2 == 0) {
                    levelValues.add(node.val);
                } else {
                    levelValues.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelValues);
            currentLevel++;
            size = queue.size();
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagBinaryTree solution = new ZigZagBinaryTree();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result); // Output: [[3], [20, 9], [15, 7]]
    }
}
