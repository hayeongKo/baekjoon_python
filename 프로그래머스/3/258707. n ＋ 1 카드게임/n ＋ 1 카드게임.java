import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        
        // 초기 패 (코인 0개로 사용 가능)
        Set<Integer> initialHand = new HashSet<>();
        for(int i = 0; i < n/3; i++) {
            initialHand.add(cards[i]);
        }
        
        // 뽑은 카드들 (코인 1개씩 필요)
        Set<Integer> drawnCards = new HashSet<>();
        
        int round = 1;
        int cardIndex = n/3;
        
        while(cardIndex < n) {
            // 라운드 시작: 카드 2장 뽑기
            drawnCards.add(cards[cardIndex]);
            drawnCards.add(cards[cardIndex + 1]);
            cardIndex += 2;
            
            boolean canPlay = false;
            
            // 1순위: 초기 패만으로 쌍 만들기 (코인 0개)
            Iterator<Integer> handIter = initialHand.iterator();
            while(handIter.hasNext() && !canPlay) {
                int card = handIter.next();
                int pair = target - card;
                if(initialHand.contains(pair) && card < pair) {
                    handIter.remove();
                    initialHand.remove(pair);
                    canPlay = true;
                }
            }
            
            // 2순위: 초기 패 + 뽑은 카드로 쌍 만들기 (코인 1개)
            if(!canPlay && coin >= 1) {
                handIter = initialHand.iterator();
                while(handIter.hasNext() && !canPlay) {
                    int card = handIter.next();
                    int pair = target - card;
                    if(drawnCards.contains(pair)) {
                        handIter.remove();
                        drawnCards.remove(pair);
                        coin--;
                        canPlay = true;
                    }
                }
            }
            
            // 3순위: 뽑은 카드끼리 쌍 만들기 (코인 2개)
            if(!canPlay && coin >= 2) {
                Iterator<Integer> drawnIter = drawnCards.iterator();
                while(drawnIter.hasNext() && !canPlay) {
                    int card = drawnIter.next();
                    int pair = target - card;
                    if(drawnCards.contains(pair) && card < pair) {
                        drawnIter.remove();
                        drawnCards.remove(pair);
                        coin -= 2;
                        canPlay = true;
                    }
                }
            }
            
            // 쌍을 만들 수 없으면 게임 종료
            if(!canPlay) {
                break;
            }
            
            round++;
        }
        
        return round;
    }
}