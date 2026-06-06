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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val == key) return merge(root);
        if(key>root.val){
            root.right = deleteNode(root.right,key);
        }
        else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
    private TreeNode merge(TreeNode node){
        TreeNode left = node.left;
        TreeNode right = node.right;
        TreeNode leaf = left;
        if(leaf==null) return right;
        while(leaf.right!=null){
            leaf = leaf.right;
        }
        leaf.right = right;
        return left;
    }
}