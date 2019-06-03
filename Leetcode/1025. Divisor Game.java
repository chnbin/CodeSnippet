/**
 * If N is even: Alice insists on choosing 1, Bob will get N - 1, N - 1 is odd.
 * If N is odd:
 *   (1) If N > 1, the factor should be odd, so whatever odd x Alice choose will make Bod get an N - x, N - x is even.
 *   (2) If N = 1, Alice fails.
 * So if N is an even and greater than 0, Alice should repeat choose X = 1. Then Bob will get 1 finally, Alice win.
 * So to check if N is even or not.
 */
class Solution {
  public boolean divisorGame(int N) {
      return N % 2 == 0;
  }
}