class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,graph,color)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int start,int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adj : graph[node]){
                if(color[adj]==-1){
                    color[adj] = 1-color[node];
                    q.offer(adj);
                }else if(color[adj]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}