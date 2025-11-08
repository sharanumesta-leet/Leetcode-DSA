class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                int top = st.peek();
                if (Math.abs(top) == Math.abs(asteroid)) {
                    st.pop();
                    destroyed = true;
                    break;
                }else if(Math.abs(top) < Math.abs(asteroid)){
                    st.pop();
                    continue;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed)
                st.push(asteroid);
        }
        int n = st.size();
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--)
            res[i] = st.pop();

        return res;
    }
}