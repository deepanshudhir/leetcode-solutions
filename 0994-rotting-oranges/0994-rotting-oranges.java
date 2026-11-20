class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        int ans=0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            ans = Math.max(time,ans);

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc,time+1});
                    fresh--;
                }
            }
        }
        if(fresh!=0) return -1;
        return ans;
    }
}