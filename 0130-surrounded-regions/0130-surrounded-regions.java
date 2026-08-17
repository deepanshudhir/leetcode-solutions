class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,board,vis);
            }
            if(board[n-1][i]=='O' && !vis[n-1][i]){
                dfs(n-1,i,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,board,vis);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                dfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board, boolean[][] vis){
        vis[i][j] = true;
        for(int k=0;k<4;k++){
            int a = i+dr[k];
            int b = j+dc[k];
            if(a>=0 && a<board.length && b>=0 && b<board[0].length && !vis[a][b] && board[a][b]=='O'){
                dfs(a,b,board,vis);
            }
        }
    }
}