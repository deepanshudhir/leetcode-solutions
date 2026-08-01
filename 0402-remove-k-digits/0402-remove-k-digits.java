class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<> ();

        for(char c : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();

        int i=0;
        while(i<res.length() && res.charAt(i)=='0'){
            i++;
        }
        String result = res.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}