class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;

            for(int ne : adj.get(curr)){
                indegree[ne]--;
                if(indegree[ne]==0){
                   q.add(ne);
                }
            }
        }
        return cnt==numCourses;
    }
}