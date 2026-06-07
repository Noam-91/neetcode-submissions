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
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inOrder(root);
        return res;
    }
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);

        count--;
        if(count==0) res = root.val;

        inOrder(root.right);
    }
}
