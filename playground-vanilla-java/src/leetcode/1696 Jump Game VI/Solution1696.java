import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution1969 {
    public static void main(String[] args) {
        var result = new Solution1969().maxResult(
                new int[]{l},
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
            System.out.println("----");
            System.out.println("dp: " + Arrays.toString(dp));
            System.out.println("queue: " + dq);
        }
        return dp[n - 1];
    }
}