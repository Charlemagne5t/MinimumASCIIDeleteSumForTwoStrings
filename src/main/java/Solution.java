import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Map<String, Integer> memo  = new HashMap<>();
        return dfs(s1, s2, 0, 0, memo);
    }
    private int dfs(String s1, String s2, int i, int j, Map<String, Integer> memo){
        if(memo.containsKey(i + " " + j)){
            return memo.get(i + " " + j);
        }
        if(i == s1.length() && j == s2.length()){
            return 0;
        }
        if(i == s1.length() && j != s2.length()){
            int leftoverSum = 0;
            while (j != s2.length()){
                leftoverSum += s2.charAt(j);
                j++;
            }
            return leftoverSum;
        }

        if(i != s1.length() && j == s2.length()){
            int leftoverSum = 0;
            while (i != s1.length()){
                leftoverSum += s1.charAt(i);
                i++;
            }
            return leftoverSum;
        }

        int result = 0;

        if (s1.charAt(i) != s2.charAt(j)) {
            int move1 = dfs(s1, s2, i + 1, j, memo) + s1.charAt(i);
            int move2 = dfs(s1, s2, i, j + 1, memo) + s2.charAt(j);
            result = Math.min(move1, move2);
        }
        if(s1.charAt(i) == s2.charAt(j)){
            result = dfs(s1, s2, i + 1, j + 1, memo);
        }
        memo.put(i + " " + j, result);
        return result;
    }
}