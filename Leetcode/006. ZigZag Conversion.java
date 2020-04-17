class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) { return s; }
        if (numRows == 1) { return s;}
        
        StringBuilder[] sb = new StringBuilder[numRows];
        StringBuilder res = new StringBuilder();
        int pos = 0;
        int direction = -1;

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        
        for (char c: s.toCharArray()) {
            sb[pos].append(c);

            if (pos == 0 || pos == numRows - 1) {
                direction *= -1;
            }

            pos += direction;
        }

        for (StringBuilder str: sb) {
            res.append(str.toString());
        }

        return res.toString();
    }
}