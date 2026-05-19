import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalTime = timeToInt(video_len);
        int posTime = timeToInt(pos);
        int op_startTime = timeToInt(op_start);
        int op_endTime = timeToInt(op_end);
        
        if (posTime >= op_startTime && posTime <= op_endTime) {
            posTime = op_endTime;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                posTime += 10;
                if (posTime > totalTime) {
                    posTime = totalTime;
                } 
            } else if (command.equals("prev")) {
                posTime -= 10;
                if (posTime < 0) {
                    posTime = 0;
                }
            }
            
            if (posTime >= op_startTime && posTime <= op_endTime) {
                posTime = op_endTime;
            }
        }
        
        String answer = intToTime(posTime);
        return answer;
    }
    
    private int timeToInt(String time) {
        String[] splited = time.split(":");
        return (Integer.parseInt(splited[0]) * 60) + Integer.parseInt(splited[1]);
    }
    
    private String intToTime(int time) {
        StringBuilder sb = new StringBuilder();
        int min = time / 60;
        int sec = time % 60;
        sb.append((int) min / 10);
        sb.append((int) min % 10);
        sb.append(":");
        sb.append((int) sec / 10);
        sb.append((int) sec % 10);
        return sb.toString();
    }
}