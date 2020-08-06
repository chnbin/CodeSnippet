class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
                int[] res = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((m1, m2) -> m2.getValue() - m1.getValue());

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        int pos = 0;

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                Map.Entry<Integer, Integer> max = pq.poll();
                res[pos] = max.getKey();
                return res;
            }
            Map.Entry<Integer, Integer> max = pq.poll();
            Map.Entry<Integer, Integer> secondMax = pq.poll();
            res[pos] = max.getKey();
            pos++;
            res[pos] = secondMax.getKey();
            pos++;

            int maxValue = max.getValue() - 1;
            if (maxValue > 0) {
                max.setValue(maxValue);
                pq.offer(max);
            }
            int secondMaxValue = secondMax.getValue() - 1;
            if (secondMaxValue > 0) {
                secondMax.setValue(secondMaxValue);
                pq.offer(secondMax);
            }
        }

        return res;
    }
}
