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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if(root.val == key) return merge(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                if(curr.left.val==key){
                    curr.left=merge(curr.left);
                    return root;
                }
                q.offer(curr.left);
            } 
            if(curr.right!=null){
                if(curr.right.val==key){
                    curr.right=merge(curr.right);
                    return root;
                }
                q.offer(curr.right);
            } 
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