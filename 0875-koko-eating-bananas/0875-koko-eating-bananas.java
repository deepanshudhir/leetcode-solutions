class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1;
        int r=0;
        for(int pile : piles) r=Math.max(r,pile);

        int ans = r;

        while(l<=r){
            int hours=0;
            int m=(l+r)/2;
            for(int pile : piles) hours+=Math.ceil((double) pile / m);
            if(hours<=h){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}