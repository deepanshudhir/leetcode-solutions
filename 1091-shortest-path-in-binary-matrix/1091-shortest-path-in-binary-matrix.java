class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[][] dis = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dis[0][0] = 1;
        pq.add(new int[]{1,0,0});

        int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int distance = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(distance > dis[r][c]) continue;
            if(r==n-1 && c==n-1) return distance;

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    int ndis = distance+1;
                    if(ndis < dis[nr][nc]){
                        dis[nr][nc] = ndis;
                        pq.add(new int[]{ndis,nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}