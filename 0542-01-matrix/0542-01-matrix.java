class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c =curr[1];
            int steps = curr[2];
            dis[r][c] = steps;
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc,steps+1});
                }
            }
        }
        return dis;
    }
}