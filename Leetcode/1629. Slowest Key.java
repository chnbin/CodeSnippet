class Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
      char res = 'a';
      int releaseTime = 0;
      
      for (int i = 0; i < releaseTimes.length; i++) {
          if (i == 0) {
              releaseTime = releaseTimes[i];
              res = keysPressed.charAt(i);
          } else {
              if (releaseTimes[i] - releaseTimes[i - 1] == releaseTime) {
                  res = (keysPressed.charAt(i) > res) ? keysPressed.charAt(i) : res;
              } else if (releaseTimes[i] - releaseTimes[i - 1] > releaseTime) {
                  releaseTime = releaseTimes[i] - releaseTimes[i - 1];
                  res = keysPressed.charAt(i);
              }
          }
      }
      
      return res;
  }
}
