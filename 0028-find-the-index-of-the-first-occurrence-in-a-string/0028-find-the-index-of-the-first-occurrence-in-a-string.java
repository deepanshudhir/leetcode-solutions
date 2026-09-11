class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        int n=haystack.length();
        int m=needle.length();
        while(i<n){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == m){ 
                    return i - j; 
                }
            }else{
                i = i - j + 1;
                j=0;
            }
        }
        return -1;
    }
}