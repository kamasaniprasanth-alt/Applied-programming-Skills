class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        // Step 1: Process first window
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        ans[0] = nums[dq.getFirst()];

        int s = 1, e = k;

        // Step 2: Process remaining windows
        while (e < nums.length) {

            // Remove elements out of window
            if (!dq.isEmpty() && dq.getFirst() == s - 1) {
                dq.removeFirst();
            }

            // Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[e]) {
                dq.removeLast();
            }

            dq.addLast(e);

            // Store result
            ans[s] = nums[dq.getFirst()];

            s++;
            e++;
        }

        return ans;
    }
}