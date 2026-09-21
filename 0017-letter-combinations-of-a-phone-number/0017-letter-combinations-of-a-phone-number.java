class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, map, new StringBuilder(), ans);

        return ans;
    }

    public void backtrack(int index, String digits,
                          String[] map,
                          StringBuilder curr,
                          List<String> ans) {

        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            curr.append(ch);

            backtrack(index + 1, digits, map, curr, ans);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}