class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> set = new ArrayList<>();
        backtrack(0,candidates, target,  new ArrayList<>(), set);
        return set;
    }
    public void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> set){
        if (target == 0) {
            set.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            current.add(candidates[i]);
            backtrack(i+1,candidates, target-candidates[i],current, set);
            current.remove(current.size() - 1);
        }
    }
}