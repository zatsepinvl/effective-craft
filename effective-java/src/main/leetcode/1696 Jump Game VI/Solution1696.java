import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution1696 {
    public static void main(String[] args) {
        var result = new Solution1696().maxResult(
                new int[]{1, 1, -2, -2, -3},
                2
        );
        System.out.println(result);
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k) dq.pollFirst();
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i - 1]) dq.pollLast();
            dq.addLast(i - 1);
            dp[i] = nums[i] + dp[dq.peekFirst()];
        }
        return dp[n - 1];
    }
}