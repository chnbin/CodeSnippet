class Solution {
    public String reorderSpaces(String text) {
        int space = 0;
        int wordCnt = 0;
        List<String> words = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (char c: text.toCharArray()) {
            if (c == ' ') {
                space++;
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }
        
        wordCnt = words.size();

        
        int spacelen = wordCnt == 1 ? 0 : (space / (wordCnt - 1));
        int spaceRemain = wordCnt == 1 ? space: (space % (wordCnt - 1));
        
        String res = "";
        for (int i = 0; i < wordCnt; i++) {
            res += words.get(i);
            if (i < wordCnt - 1) {
                res += genCharByTimes(' ', spacelen);
            }
        }

        res += genCharByTimes(' ', spaceRemain);
        return res;
    }
    
    String genCharByTimes(char c, int times) {
        StringBuilder sb = new StringBuilder();
        
        while (times > 0) {
            sb.append(c);
            times--;
        }
        
        return sb.toString();
    }
}
