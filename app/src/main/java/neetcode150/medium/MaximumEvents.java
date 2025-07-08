package neetcode150.medium;

//Link https://leetcode.com/problems/3sum/
import java.util.*;

public class MaximumEvents {
    public int maxEvents(int[][] events) {
        int ans=0;
        int g_end = 0;
        HashMap<Integer, List<Integer>> sortedEvents = new HashMap<>();

        Arrays.sort(events, (a,b) -> (a[0]-b[0]));

        for(int[] event: events){
            g_end= Integer.max(event[1],g_end);
        }

        PriorityQueue<Integer> queue_for_track = new PriorityQueue<>();

        int k=0;

        for(int i=1; i<=g_end; i++){
            while((!queue_for_track.isEmpty()) && (queue_for_track.peek()<i)){
                queue_for_track.poll();
            }

            while(k<events.length && (events[k][0]<=i)){
                queue_for_track.offer(events[k][1]);
                k++;
            }

            if(!queue_for_track.isEmpty()){
                queue_for_track.poll();
                ans+=1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = {
                {1, 2},
                {2,3},
                {3,4}
        };
        MaximumEvents solution = new MaximumEvents();
        int result = solution.maxEvents(events);
        System.out.println(result); // 3
    }
}
