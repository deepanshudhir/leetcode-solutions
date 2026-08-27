class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(effort[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        effort[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int e = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r==n-1 && c==m-1) return e;

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int diff = Math.abs(heights[r][c]-heights[nr][nc]);
                    int newEffort = Math.max(diff,e);

                    if(newEffort < effort[nr][nc]){
                        effort[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}