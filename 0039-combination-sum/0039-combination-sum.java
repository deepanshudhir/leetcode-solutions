class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int[] candidates, int target, int idx, List<Integer> curr , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length || target < 0){
            return;
        }
        solve(candidates, target, idx+1, curr, ans);
        curr.add(candidates[idx]);
        solve(candidates, target-candidates[idx] , idx, curr, ans);
        curr.remove(curr.size()-1);
    }
}