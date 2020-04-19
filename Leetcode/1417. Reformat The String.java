class Solution {
    public String reformat(String s) {
        List<Character> digitList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitList.add(c);
            } else {
                numList.add(c);
            }
        }
        
        // Determine to pick digit first or pick number first.
        boolean isDigit = (digitList.size() > numList.size()) ? true : false;
        int digitCnt = 0;
        int numCnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isDigit) {
                if (digitCnt == digitList.size()) {
                    return "";
                }
                sb.append(digitList.get(digitCnt));
                digitCnt++;
            } else {
                if (numCnt == numList.size()) {
                    return "";
                }
                sb.append(numList.get(numCnt));
                numCnt++;
            }
            isDigit = !isDigit;
        }
        
        return sb.toString();
    }
}
