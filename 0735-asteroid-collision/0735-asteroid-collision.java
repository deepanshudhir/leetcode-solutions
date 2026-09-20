class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            while (alive && asteroid < 0 && !st.isEmpty() && st.peek() > 0) {

                if (st.peek() < -asteroid) {
                    // stack asteroid explodes
                    st.pop();
                }
                else if (st.peek() == -asteroid) {
                    // both explode
                    st.pop();
                    alive = false;
                }
                else {
                    // current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}