package neetcode150.medium;

//Link https://leetcode.com/problems/meeting-rooms-iii/description/?envType=daily-question&envId=2025-07-11

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> (a[0]-b[0]));
        PriorityQueue<int[]> end_track = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        PriorityQueue<Integer> room_track = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            room_track.offer(i);
        }

        int[] count_events= new int[n];

        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];

            while(!end_track.isEmpty() && end_track.peek()[0]<=start){
                room_track.offer(end_track.poll()[1]);
            }

            int roomID;

            if(!room_track.isEmpty()){
                roomID=room_track.poll();
                end_track.offer(new int[] {end, roomID});
            }else{
                int[] last = end_track.poll();
                roomID = last[1];
                end_track.offer(new int[] {last[0]+end-start,roomID});
            }

            count_events[roomID]+=1;
        }


        int max_used_room=0;
        for(int i=0;i<n;i++){
            if(count_events[max_used_room]<count_events[i]){
                max_used_room = i;
            }
        }
        return max_used_room;
    }

    public static void main(String[] args) {
        int[][] events = {
                {0,10},{1,5},{2,7},{3,4}
        };
        MeetingRoomsIII solution = new MeetingRoomsIII();
        int result = solution.mostBooked(2, events);
        System.out.println(result); // 0
    }
}
