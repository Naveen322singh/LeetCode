class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] mp = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            mp[task - 'A']++;
        }

        // Max heap (priority queue with reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int freq : mp) {
            if (freq > 0) {
                pq.add(freq);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            // Try to execute up to n+1 tasks in this cycle
            for (int i = 1; i <= n + 1; i++) {
                if (!pq.isEmpty()) {
                    int f = pq.poll();
                    f--;
                    temp.add(f);
                }
            }

            // Push remaining tasks back into queue
            for (int f : temp) {
                if (f > 0) pq.add(f);
            }

            // Count time: if pq still has tasks, full cycle (n+1), else only executed tasks
            if (!pq.isEmpty()) time += n + 1;
            else time += temp.size();
        }

        return time;
    }
}