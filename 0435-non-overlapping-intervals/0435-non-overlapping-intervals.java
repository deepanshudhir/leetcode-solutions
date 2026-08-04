class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int cnt=1;
        int pt = intervals[0][1];
        for(int i=1;i < intervals.length; i++){
            if(intervals[i][0]>=pt){
                cnt+=1;
                pt = intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }
}