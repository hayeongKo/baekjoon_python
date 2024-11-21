import java.util.*;

class Solution {
    HashMap<String, Integer> menus;
    boolean[] visited;
    List<String> res;

    public String[] solution(String[] orders, int[] courses) {
        res = new ArrayList<>();

        for (int course : courses) {
            menus = new HashMap<>();

            for (String order : orders) {
                if (order.length() < course) continue;

                visited = new boolean[order.length()];
                char[] sortedOrder = order.toCharArray();
                Arrays.sort(sortedOrder);
                dfs(sortedOrder, 0, course);
            }

            if (menus.isEmpty()) continue;

            
            int max = Collections.max(menus.values());
            if (max < 2) continue;

            for (Map.Entry<String, Integer> entry : menus.entrySet()) {
                if (entry.getValue() == max) {
                    res.add(entry.getKey());
                }
            }
        }

        Collections.sort(res);

        String[] answer = new String[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void dfs(char[] order, int start, int depth) {
        if (depth == 0) {
            // map에 추가
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < order.length; i++) {
                if (visited[i]) sb.append(order[i]);
            }

            String combination = sb.toString();
            menus.put(combination, menus.getOrDefault(combination, 0) + 1);
            return;
        }

        // 조합
        for (int i = start; i < order.length; i++) {
            visited[i] = true;
            dfs(order, i + 1, depth - 1);
            visited[i] = false;
        }
    }
}
