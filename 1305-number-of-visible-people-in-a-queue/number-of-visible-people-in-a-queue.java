class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                st.pop();
                count++;
            }
            res[i] = ((st.isEmpty()) ? 0 : 1) + count;
            st.push(i);
        }
        return res;
    }
}