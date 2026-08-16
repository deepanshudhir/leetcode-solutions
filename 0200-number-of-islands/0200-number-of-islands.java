class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;

    }
    public void dfs(int i,int j,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0 || j>=m || i>=n || grid[i][j]!='1') return;
        grid[i][j] = 0;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}