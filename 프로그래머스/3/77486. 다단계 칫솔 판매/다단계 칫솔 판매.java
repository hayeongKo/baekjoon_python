import java.util.*;

class Node {
    Node parent;
    String name;
    int income;
    int distribution;
    Node(String name) {
        this.name = name;
    }
}

class Solution {
    List<Node> nodes = new ArrayList<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 노드 생성
        for(String name: enroll) {
            nodes.add(new Node(name));
        }
        
        // 추천인 등록
        for(int i = 0; i < referral.length; i++) {
            if(referral[i].equals("-")) {
                nodes.get(i).parent = new Node("center");
            } else {
                nodes.get(i).parent = findNode(referral[i]);
            }
        }
        
        // 수익분배
        for(int i = 0; i < seller.length; i++) {
            Node sellerNode = findNode(seller[i]);
            sellerNode.distribution = amount[i]*100;
            if(sellerNode.parent != null) {
                distribute(sellerNode);
            }
        }
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = nodes.get(i).income;
        }
        
        return answer;
    }
    
    public Node findNode(String name) {
        for(Node node : nodes) {
            if(node.name.equals(name)) {
                return node;
            }
        }
        return null;
    }
    
    public void distribute(Node start) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(current.parent != null) {
                int distribution = (int) (current.distribution*0.1);
                
                current.parent.distribution += distribution;
                current.distribution -= distribution;
                
                current.income += current.distribution;
                current.distribution = 0;
                
                if(current.parent.distribution == 0) {
                    break;
                }
                queue.offer(current.parent);
            }
        }
    }
}