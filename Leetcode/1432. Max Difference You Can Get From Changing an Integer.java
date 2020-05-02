/*
	Biweekly Contest 25
	https://leetcode.com/contest/biweekly-contest-25
	I spent too much time doing this problem...
*/

class Solution {
    public int maxDiff(int num) {
        return findMax("" + num) - findMin("" + num);
    }
    
    private int findMax(String num) {
        char maxChar = '9';
        int res = 0;
        
        for (char c: num.toCharArray()) {
            if (c != '9') {
                maxChar = c;
                break;
            }
        }
        
        for (char c: num.toCharArray()) {
            res *= 10;
            if (c == maxChar) {
                res += 9;
            } else {
                res += (c - '0');
            }
        }
        System.out.println(res);
        return res;
    }
    
    private int findMin(String num) {
        char minChar = '-';
        int res = 0;
        
        if (num.charAt(0) != '1') {
            minChar = num.charAt(0);
            res = 0;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                res *= 10;
                if (c == minChar) {
                    res += 1;
                } else {
                    res += (c - '0');
                }
            }
        } else {
            for (int i = 1; i < num.length(); i++) {
                char c = num.charAt(i);
                
                if (c != '1' && c != '0') {
                    minChar = c;
                    break;
                }
            }
            
            for (char c: num.toCharArray()) {
                res *= 10;
                if (c == minChar) {
                    res += 0;
                } else {
                    res += (c - '0');
                }
            }
        }
        
        
        System.out.print(res);
        return res;
    }
}
