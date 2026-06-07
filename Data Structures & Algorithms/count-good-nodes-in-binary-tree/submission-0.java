/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        validate(root, root.val);
        return count;
    }

    private void validate(TreeNode root, int max){
        if(root==null) return;
        if(root.val>=max) count++;
        max = Math.max(max,root.val);
        validate(root.left,max);
        validate(root.right,max);
    }
}
