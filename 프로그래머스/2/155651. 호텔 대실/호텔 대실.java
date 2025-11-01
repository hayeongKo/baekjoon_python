import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<String> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0])); // 시작시간 기준 정렬
        
        for(String[] book : book_time) {
            String startTime = book[0];
            String endTime = book[1];
            
            // 청소시간 고려한 실제 종료시간 계산
            String cleanEndTime = addMinutes(endTime, 10);
            
            // 사용 가능한 방 확인
            while(!pq.isEmpty() && pq.peek().compareTo(startTime) <= 0) {
                pq.poll();
            }
            
            pq.offer(cleanEndTime);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    public String addMinutes(String time, int minutes) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        
        minute += minutes;
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        
        return String.format("%02d:%02d", hour, minute); // 두 자리 포맷 유지
    }
}