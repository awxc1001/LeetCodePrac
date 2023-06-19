class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        
        //sort the array by ranking from the earilist starting time at the first index
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        for(int i =0; i<intervals.length-1; i++){
            // check from earilist meeting, if any of the end time
            // exceeds next meeting start time 
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}