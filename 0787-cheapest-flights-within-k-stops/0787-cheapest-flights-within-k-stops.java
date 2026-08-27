class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            int u = f[0];
            int v = f[1];
            int cost = f[2];
            adj.get(u).add(new int[]{v,cost});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,src,0});

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int stops = curr[0];
            int city = curr[1];
            int cost = curr[2];

            if(stops > k) continue;

            for(int[] edge : adj.get(city)){
                int nextCity = edge[0];
                int newCost = cost + edge[1];

                if(newCost < dis[nextCity]){
                    dis[nextCity] = newCost;
                    q.add(new int[]{stops+1,nextCity,newCost});
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE ? -1 : dis[dst];
    }
}