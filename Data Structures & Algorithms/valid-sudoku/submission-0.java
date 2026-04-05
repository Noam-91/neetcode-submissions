class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] checkMap = new int[27][9]; //row 0-8, col 9-17, mini 18-26
        for(int row=0; row< board.length;row++){
            for(int col = 0; col<board[row].length;col++){
                if(board[row][col]=='.'){
                    continue;
                }
                // check row
                if(checkMap[row][board[row][col]-'0'-1] == 1){
                    return false;
                }
                checkMap[row][board[row][col]-'0'-1] = 1;
                // check col
                if(checkMap[9+col][board[row][col]-'0'-1] == 1){
                    return false;
                }
                checkMap[9+col][board[row][col]-'0'-1] = 1;
                // check mini
                int miniIdx = row/3*3+col/3;
                if(checkMap[18+miniIdx][board[row][col]-'0'-1] == 1){
                    return false;
                }
                checkMap[18+miniIdx][board[row][col]-'0'-1] = 1;
            }
        }
        return true;
    }
}
