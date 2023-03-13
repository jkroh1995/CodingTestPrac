import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];
        Map<String, Integer>wordIndex = new HashMap<>();
        
        for (String s : keymap) {
            makeWordIndex(wordIndex, s);
        }

        for(int i=0;i< targets.length;i++){
            calculateAnswer(targets, answer, wordIndex, i);
        }

        return answer;
    }

    private static void calculateAnswer(String[] targets, int[] answer, Map<String, Integer> wordIndex, int i) {
        for(int j = 0; j< targets[i].length(); j++){
            if(!wordIndex.containsKey(String.valueOf(targets[i].charAt(j)))){
                answer[i]=-1;
                break;
            }
            answer[i]+= wordIndex.get(String.valueOf(targets[i].charAt(j)));
        }
    }

    private static void makeWordIndex(Map<String, Integer> wordIndex, String s) {
        for (int j = 0; j < s.length(); j++) {
            if (wordIndex.containsKey(String.valueOf(s.charAt(j)))) {
                int index = wordIndex.get(String.valueOf(s.charAt(j)));
                if (j+1 < index) {
                    wordIndex.put(String.valueOf(s.charAt(j)), j+1);
                }
                continue;
            }
            wordIndex.put(String.valueOf(s.charAt(j)), j+1);
        }
    }
}
