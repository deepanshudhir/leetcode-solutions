class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k,n,1,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int k, int n, int idx, List<Integer> curr, List<List<Integer>> ans){
        if(n==0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx>9 || n<0 || curr.size()>k) return;

        for(int i=idx; i<=9; i++){
            curr.add(i);
            backtrack(k,n-i,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}