/*
	Biweekly Contest 25
	https://leetcode.com/contest/biweekly-contest-25
	Easy problem.
*/
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxCandy = 0;
        
        for (int candy: candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        
        for (int candy: candies) {
            if (candy == maxCandy || (Math.abs(candy + extraCandies) >= maxCandy)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        
        return res;
    }
}
