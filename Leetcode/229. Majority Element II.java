class Solution {
  public List<Integer> majorityElement(int[] nums) {
      // It is impossible that there are three elements that appear more than n/3 times.
      // So there are at most two elements that appear more than n/2 times.
      // Using the Boyer-Moore Voting Algorithm again, 
      // but we keep tracking two candidates in this problems.
      int candidate1  = 0, counter1 = 0, candidate2  = 0, counter2 =0;
      List<Integer> res = new ArrayList<>();

      for (int num: nums) {
          if (num == candidate1) {
              counter1++;
          } else if (num == candidate2) {
              counter2++;
          } else if (counter1 == 0) {
              candidate1 = num;
              counter1 = 1;
          } else if (counter2 == 0) {
              candidate2 = num;
              counter2 = 1;
          } else {
              counter1--;
              counter2--;
          }
      }
      
      // Valid 
      counter1 = 0;
      counter2 = 0;
      
      for (int num: nums) {
          // To avoid [0,0,0,0,0,0,0]
          if (num == candidate1) {
              counter1++;
          } else if (num == candidate2) {
              counter2++;
          }
      }
      if (counter1 > nums.length/3) { res.add(candidate1); }
      if (counter2 > nums.length/3) { res.add(candidate2); }
      return res;
  }
}