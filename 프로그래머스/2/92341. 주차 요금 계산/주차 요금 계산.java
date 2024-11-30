import java.util.*;

class Solution {
    class Record {
        String at;  
        int total;

        Record(String at) {
            this.at = at;
            this.total = 0;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Record> cars = new HashMap<>();

        
        for (String record : records) {
            String[] temps = record.split(" ");
            String at = temps[0];
            String carId = temps[1];
            String action = temps[2];

            if (action.equals("IN")) {
                if(cars.containsKey(carId)) {
                    cars.get(carId).at = at;
                } else {
                    cars.put(carId, new Record(at));
                }
            } else {
                Record r = cars.get(carId);
                r.total += diffTime(r.at, at);
                r.at = null;  // 출차 완료
            }
        }

        for (String carId : cars.keySet()) {
            Record r = cars.get(carId);
            if (r.at != null) {  // 출차되지 않음
                r.total += diffTime(r.at, "23:59");
            }
        }

        TreeMap<String, Record> sortedCars = new TreeMap<>(cars);
        int[] result = new int[sortedCars.size()];
        
        int i = 0;
        for (Record r : sortedCars.values()) {
            result[i++] = calFee(r.total, fees);
        }

        return result;
    }


    public int diffTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        return endMin - startMin;
    }

    
    public int calFee(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        }

        return baseFee + (int) Math.ceil((double) (totalTime - baseTime) / unitTime) * unitFee;
    }
}
