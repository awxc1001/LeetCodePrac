class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        List<int[]> timeLinelist = new ArrayList<>();
        
        for(int[] interval: intervals){
            //add start and finish timestamp and give them type, start 1, end -1
            timeLinelist.add(new int[]{interval[0],1});
            timeLinelist.add(new int[]{interval[1],-1});
        }
        
        //sort the list by time, if same time, sort by end then start
        Collections.sort(timeLinelist, (a,b) -> a[0] == b[0] ?                                           Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])); 
        
        
        //loop the list to see the max starting point of each meeting line
        int count = 0;
        int res = 0;
        for(int[] meeting: timeLinelist){
            count += meeting[1];  //second index store the meeting time type:1 1 -1 -1
            res = Math.max(res,count);    
        }
        
        return res;
    }
}