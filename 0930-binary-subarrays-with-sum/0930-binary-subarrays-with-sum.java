class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt=0;
        Map<Integer,Integer> mp = new HashMap<>();
        int sum=0;
        mp.put(0,1);

        for(int n : nums){
            sum+=n;

            if(mp.containsKey(sum-goal)){
                cnt += mp.get(sum-goal); 
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}