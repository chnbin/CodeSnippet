import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> addToArrayForm(int[] A, int K) {
      List<Integer> res = new ArrayList<Integer>();
      LinkedList<Integer> stack = new LinkedList<>();
      
      String strK = String.valueOf(K);
      int[] nums = new int[strK.length()];
      
      for (int i = 0; i < strK.length(); i++) {
          int num = (int)strK.charAt(i) - '0';
          nums[i] = num;
      }
      int posA = A.length - 1;
      int posK = nums.length - 1;
      int carry = 0;
      
      while (posA > -1 || posK > -1) {
          int digit = carry;
          
          if (posA >= 0) {
              digit += A[posA];
              posA--;
          }
          
          if (posK >= 0) {
              digit += nums[posK];
              posK--;
          }
          
          stack.push(digit % 10);
          carry = digit / 10;
      }
      
      if (carry > 0) { stack.push(1); }
      
      while (!stack.isEmpty()) {
          res.add(stack.pop());
      }
      
      return res;
  }
}