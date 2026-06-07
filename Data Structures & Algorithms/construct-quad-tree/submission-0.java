/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) return null;
        return dfs(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node dfs(int[][] grid, int top, int bot, int left, int right) {
        if (bot - top == 1) {
            return new Node(grid[top][left] == 1, true);
        }

        int rowMid = top + (bot - top) / 2;
        int colMid = left + (right - left) / 2;

        Node topLeftRes = dfs(grid, top, rowMid, left, colMid);
        Node topRightRes = dfs(grid, top, rowMid, colMid, right);
        Node botLeftRes = dfs(grid, rowMid, bot, left, colMid);
        Node bottomRightRes = dfs(grid, rowMid, bot, colMid, right);

        if (topLeftRes.isLeaf && topRightRes.isLeaf && botLeftRes.isLeaf && bottomRightRes.isLeaf
            && topLeftRes.val == topRightRes.val 
            && topLeftRes.val == botLeftRes.val 
            && topLeftRes.val == bottomRightRes.val) {
            
            return new Node(topLeftRes.val, true);
        }

        return new Node(true, false, topLeftRes, topRightRes, botLeftRes, bottomRightRes);
    }
}