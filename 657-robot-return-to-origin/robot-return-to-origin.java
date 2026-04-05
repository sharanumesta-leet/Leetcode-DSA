class Solution {
    public boolean judgeCircle(String moves) {
        int xAxis = 0;
        int yAxis = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'R':
                    xAxis++;
                    break;
                case 'L':
                    xAxis--;
                    break;
                case 'U':
                    yAxis++;
                    break;
                case 'D':
                    yAxis--;
                    break;
            }
        }
        if (xAxis == 0 && yAxis == 0)
            return true;
        return false;
    }
}