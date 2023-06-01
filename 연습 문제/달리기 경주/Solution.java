import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> nameRank = new HashMap<>();
        Map<Integer, String> rankName = new HashMap<>();

        for(int i = 0;i< players.length;i++){
            nameRank.put(players[i], i);
            rankName.put(i, players[i]);
        }

        for(String call : callings){
            int rank = nameRank.get(call);
            String beforeName = rankName.get(rank-1);
            
            nameRank.put(call, rank-1);
            nameRank.put(beforeName, rank);
            
            rankName.put(rank-1, call);
            rankName.put(rank, beforeName);
        }

        for(int rank : rankName.keySet()){
            answer[rank] = rankName.get(rank);
        }
        return answer;
    }
}
