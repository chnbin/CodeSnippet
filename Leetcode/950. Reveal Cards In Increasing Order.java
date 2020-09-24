class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(deck[deck.length - 1]);
        // 2, 3, 5, 7, 11, 13, 17
        
        for (int i = deck.length - 2; i >= 0; i--) {
            int last = deque.pollLast();
            deque.offerFirst(last);
            deque.offerFirst(deck[i]);
        }
        
        int pos = 0;
        while (!deque.isEmpty()) {
            res[pos] = deque.pollFirst();
            pos++;
        }
        
        return res;
    }
}
