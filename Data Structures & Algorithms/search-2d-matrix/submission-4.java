class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // bs in col 1
        int u=0,b=matrix.length;
        while(u<b){
            int m = u+(b-u)/2;
            if(matrix[m][0]<=target){
                u=m+1;
            }else{
                b=m;
            }
        }
        u--;
        if (u<0||target < matrix[u][0] || target > matrix[u][matrix[0].length-1]) return false;
        // bs in row u
        int l=0,r=matrix[0].length;
        while(l<r){
            int m = l+(r-l)/2;
            if(matrix[u][m]<target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return matrix[u][l]==target;
    }
}
