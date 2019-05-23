class Solution {
  /**
     * Using bits to map string. Because each words contains lower case character, 
     * 26 bits is enough. So we use a integer to stand for a word.
     * For example: words = ["abc", "cde", "def"]
     * abc => bits [0] 00000000000000000000000000000111
     * cde => bits [1] 00000000000000000000000000011100
     * def => bits [2] 00000000000000000000000000111000
     * 
     * bits[i] & bits[j] equals 0 means words i and words j do not share common letter.
     * we can take words[i].length()*words[j].length as candicator.
     */
public int maxProduct(String[] words) {
    if (words == null || words.length == 0) { return 0; }
    int[] bits = new int[26];
    int res = 0;
    int len = words.length;

    for (int i = 0; i < len; i++) {
        
        for (int j = 0; j < words[i].length(); j++) {
            bits[i] = bits[i] | (1 << (words[i].charAt(j) - 'a'));
        }
        
        for (int k = 0; k < i; k++) {
            if ((bits[i] & bits[k]) == 0) {
                res = Math.max(res, words[i].length() * words[k].length());
            }
        }
    }
    return res;
}
}