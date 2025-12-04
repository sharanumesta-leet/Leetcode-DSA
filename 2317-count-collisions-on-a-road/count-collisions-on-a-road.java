class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        int rCount = 0;
        char prev = '#';
        Deque<Character> st = new ArrayDeque<>();
        for (char car : directions.toCharArray()) {
            if (car == 'R') {
                if (prev == 'L') {
                    st.clear();
                    rCount = 0;
                }
                st.push(car);
                rCount++;
            } else if (car == 'S') {
                while (!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    count++;
                }
                if (st.isEmpty() || st.peek() != 'S')
                    st.push(car);
                rCount = 0;
            } else if (!st.isEmpty() && car == 'L') {
                if (st.peek() == 'S')
                    count++;
                else {
                    count += rCount + 1;
                    st.push('S');
                }
            }
            prev = car;
        }
        return count;
    }
}