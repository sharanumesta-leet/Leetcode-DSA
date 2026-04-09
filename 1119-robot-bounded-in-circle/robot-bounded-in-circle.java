class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0;
        int y = 0;
        int d = 0;
        for (char i : instructions.toCharArray()) {
            if ('R' == i)
                d = (d + 1) % 4;
            else if ('L' == i)
                d = (d + 3) % 4;
            else {
                x += dir[d][0];
                y += dir[d][1];
            }
        }
        return 0 == x && 0 == y || d != 0;
    }
}