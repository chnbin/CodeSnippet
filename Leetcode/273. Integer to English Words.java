class Solution {
  public String numberToWords(int num) {
      if (num == 0) { return "Zero"; }
      String res = "";
      int level = 0;
      
      while (num > 0) {
          String tmp = "";
          int threeDigits = num % 1000;
          String label = getLabel(level);
          int firstDigits = threeDigits / 100;
          int lastTwoDigits = threeDigits % 100;
          String hundred = getEnglish(firstDigits);
          String lastTwo = getEnglish(lastTwoDigits);
          
          if (hundred.length() > 0) {
              tmp = hundred + " Hundred";
          }
          
          if (lastTwo.length() > 0) {
              if (tmp.length() == 0) {
                  tmp = lastTwo;
              } else {
                  tmp = tmp + " " + lastTwo;
              }
          }
          
          if (label.length() > 0 && tmp.length() > 0) {
              tmp = tmp + " " + label;
          }
          if (tmp.length() > 0) {
              if (res.length() == 0) {
                  res = tmp;
              } else {
                  res = tmp + " " + res; 
              }
          }

          level++;
          num/=1000;
      }
      
      return res;
  }
  
  private String getLabel(int level) {
      String label = "";
      
      // Input is less than 2^31 - 1, the highest level
      // is billion.
      switch (level) {
          case 1:
              label = "Thousand";
              break;
          case 2:
              label = "Million";
              break;
          case 3:
              label = "Billion";
              break;
          default:
              label = "";
      }
      return label;
  }
  
  private String getEnglish(int num) {
      String res = "";
      if (num < 20) {
          res = getUnder20(num);
      } else {
          if (num % 10 == 0) {
              res = get10n(num/10 * 10);
          } else {
              res = get10n(num/10 * 10) + " " + getUnder20(num % 10);
          }
          
      }
      return res;
  }
  
  private String getUnder20(int num) {
      String res = "";
      switch (num) {
          case 1:
              res = "One";
              break;
          case 2:
              res = "Two";
              break;
          case 3:
              res = "Three";
              break;
          case 4:
              res = "Four";
              break;
          case 5:
              res = "Five";
              break;
          case 6:
              res = "Six";
              break;
          case 7:
              res = "Seven";
              break;
          case 8:
              res = "Eight";
              break;
          case 9:
              res = "Nine";
              break;
          case 10:
              res = "Ten";
              break;
          case 11:
              res = "Eleven";
              break;
          case 12:
              res = "Twelve";
              break;
          case 13:
              res = "Thirteen";
              break;
          case 14:
              res = "Fourteen";
              break;
          case 15:
              res = "Fifteen";
              break;
          case 16:
              res = "Sixteen";
              break;
          case 17:
              res = "Seventeen";
              break;
          case 18:
              res = "Eighteen";
              break;
          case 19:
              res = "Nineteen";
              break;
      }
      return res;
  }
  
  private String get10n(int num) {
      String res = "";
      
      switch (num) {
          case 20:
              res = "Twenty";
              break;
          case 30:
              res = "Thirty";
              break;
          case 40:
              res = "Forty";
              break;
          case 50:
              res = "Fifty";
              break;
          case 60:
              res = "Sixty";
              break;
          case 70:
              res = "Seventy";
              break;
          case 80:
              res = "Eighty";
              break;
          case 90:
              res = "Ninety";
              break;
      }
      
      return res;
  }
}