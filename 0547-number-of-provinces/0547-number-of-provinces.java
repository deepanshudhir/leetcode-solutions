class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                provinces++;
                dfs(i,isConnected,vis);
            }
        }
        return provinces;
    }
    public void dfs(int city,int[][] isConnected, boolean[] vis){
        vis[city] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[city][i]==1 && !vis[i]){
                dfs(i,isConnected,vis);
            }
        }
    }
}