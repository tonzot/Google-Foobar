import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static int solution(int[] l){
        if (l.length < 3){
            return 0;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        graph.put(0, Collections.emptySet());

        for(int i = 1; i < l.length; i++){
            graph.put(i, new HashSet<>());
            for(int j = 0; j < i; j++){
                if(l[i] % l[j] == 0){
                    graph.get(i).add(j);
                }
            }
        }

        int counter = 0;

        for(int node : graph.keySet()){
            for(int neighbour : graph.get(node)){
                counter += graph.get(neighbour).size();
            }
        }

        return counter;
    }
}
