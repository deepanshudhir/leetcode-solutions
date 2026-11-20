class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int cnt=0;

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,isConnected,vis);
            }
        }
        return cnt;
    }
    public void dfs(int i, int[][] isConnected, int[] vis){
        int n = isConnected.length;
        vis[i] = 1;

        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && vis[j]==0){
                dfs(j,isConnected,vis);
            }
        }
    }
}