class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor==color) return image;
        dfs(sr,sc,image,color,originalColor);
        return image;
    }
    public void dfs(int i,int j,int[][]image, int color,int originalColor){
        int n = image.length;
        int m = image[0].length;
        if(i<0 || j<0 || i>=n || j>=m || image[i][j]!=originalColor) return;
        image[i][j] = color;
        dfs(i+1,j,image,color,originalColor);
        dfs(i-1,j,image,color,originalColor);
        dfs(i,j-1,image,color,originalColor);
        dfs(i,j+1,image,color,originalColor);
    }
}