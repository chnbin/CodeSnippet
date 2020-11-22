class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return combine(word1).equals(combine(word2));
    }
    
    private String combine(String[] word) {
        StringBuilder sb = new StringBuilder();
        
        for (String w: word) {
            sb.append(w);
        }
        
        return sb.toString();
    }
}
