class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int xt = target[0];
        int yt = target[1];
        int dist = Math.abs(xt) + Math.abs(yt);

        for (int[] ghost : ghosts) {
            int xg = ghost[0];
            int yg = ghost[1];
            int ghostDist = Math.abs(xt - xg) + Math.abs(yt - yg);
            if (ghostDist <= dist)
                return false;
        }
        return true;
    }
}