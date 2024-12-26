import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {  
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, target, 0, 0, memo);
    }
    int dfs(int[] nums, int target, int i, int sum,   Map<Integer, Integer> memo) {
        if(i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if(memo.containsKey(i + sum * 100_000)) {
            return memo.get(i + sum * 100_000);
        }
        int add = dfs(nums, target, i + 1, sum + nums[i], memo);
        int sub = dfs(nums, target, i + 1, sum - nums[i], memo);
        int res = add + sub;
        memo.put(i + sum * 100_000, res);
        return add + sub;
    }
}