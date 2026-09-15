class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    public int atmost(int[] nums, int k){
        if(k==0) return 0;

        Map<Integer,Integer> mp = new HashMap<>();

        int l=0;
        int ans=0;

        for(int r=0;r<nums.length;r++){
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);

            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);

                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}