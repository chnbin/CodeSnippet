class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      for (int i = 0; i < letters.length; i++) {
          if (target - letters[i] < 0) {
              return letters[i];
          } else {
              if (i == letters.length - 1) {
                  return letters[0];
              }
          }
      }
      return letters[0];
  }
}