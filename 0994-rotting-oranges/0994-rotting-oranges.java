class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int fresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        int ans=0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            ans = Math.max(time, ans);

            for(int k=0;k<4;k++){
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc,time+1});
                    fresh--;
                }
            }
        }
        if(fresh!=0) return -1;
        return ans;
    }
}