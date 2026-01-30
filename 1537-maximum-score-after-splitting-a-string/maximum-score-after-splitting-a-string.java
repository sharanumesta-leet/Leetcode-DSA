class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int cnt0=0,cnt1=0;
        int[] zeros = new int[len];
        int[] ones = new int[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='0') {
                cnt0++;
            }
            zeros[i]=cnt0;
        }
        for(int i=len-1;i>-1;i--){
            if(s.charAt(i)=='1') {
                cnt1++;
            }
            ones[i]=cnt1;
            
        }
        
        int ans = 0;
        for(int i=1;i<len;i++){
            ans = Math.max(ans,zeros[i-1]+ones[i]);
        }
        return ans;
    }
}