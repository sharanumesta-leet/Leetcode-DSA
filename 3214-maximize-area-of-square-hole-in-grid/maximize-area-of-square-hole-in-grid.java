class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int curSeq = 1;
        int maxHSeq = 1;
        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i] + 1 == hBars[i + 1])
                curSeq++;
            else
                curSeq = 1;
            maxHSeq = Math.max(maxHSeq, curSeq);
        }
        curSeq = 1;
        int maxVSeq = 1;
        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i] + 1 == vBars[i + 1])
                curSeq++;
            else
                curSeq = 1;
            maxVSeq = Math.max(maxVSeq, curSeq);
        }
        int l = Math.min(maxVSeq, maxHSeq) + 1;
        return l * l;
    }
}