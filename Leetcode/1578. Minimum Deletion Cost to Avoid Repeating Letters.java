class Solution {
    public int minCost(String s, int[] cost) {
        /*
            以aaaaaa, 成本1,2,3,4,5,6為例。要讓重複字串消失必得砍掉5個字元。
            要讓砍掉的成本最小，我們應該要留下最大成本的字元，砍掉五個成本比較小的字元。
        */
        if (cost.length < 2) { return 0; }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 0;
        int pos = 0;
        
        while (pos < cost.length) {
            int next = pos + 1;
            pq.offer(cost[pos]);
            
            // 由此字元開始找是否有重複字元，有的話把成本加到min-heap
            while (next < cost.length && (s.charAt(pos) == s.charAt(next))) {
                pq.offer(cost[next]);
                next++;
            }
            
            // 若pq為1，代表目前字元並無重複，因此可以不用計算
            if (pq.size() == 1) {
                pq.poll();
            } else {
                // 有重複，需要計算除了最大成本以外的成本總和
                while (pq.size() != 1) {
                    res += pq.poll();
                }
                pq.poll();
            }
            pos = next;
        }

        return res;
    }
}
