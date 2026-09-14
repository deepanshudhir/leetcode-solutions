class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int[] freq = new int[26];

        int maxl=0;
        int maxf=0;

        for(int r=0;r<s.length();r++){
            char a = s.charAt(r);
            freq[a-'A']++;
            maxf = Math.max(maxf,freq[a-'A']);

            while(r-l-maxf+1 > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxl = Math.max(maxl,r-l+1);
        }
        return maxl;
    }
}