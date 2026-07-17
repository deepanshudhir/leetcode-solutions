class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l=0;
        int r=0;
        int maxlen=0;
        int n = s.length();
        while(r < n){
            char a = s.charAt(r);
            if(mp.containsKey(a) && mp.get(a) >= l){
                l = mp.get(a)+1;
            }
            mp.put(a, r);
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }
}