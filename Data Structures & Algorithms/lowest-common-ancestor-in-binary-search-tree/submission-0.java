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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPQ(root,p,q);
        return lca;
    }
    private boolean[] findPQ(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return new boolean[] {false, false};
        boolean[] leftRes = findPQ(root.left,p,q);
        boolean[] rightRes = findPQ(root.right,p,q);
        boolean hasP = leftRes[0] || rightRes[0] || root.val == p.val;
        boolean hasQ = leftRes[1] || rightRes[1] || root.val == q.val;
        if(hasP && hasQ && lca==null) lca = root;
        return new boolean[] {hasP,hasQ};
    }
}
