class Solution {
    public String alphabetBoardPath(String target) {
        int currRow = 0;
        int currCol = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char c: target.toCharArray()) {
            // If character is m, 'm' - 'a' = 12
            // 12 / 2 = 2, 12 % 5 = 2
            // m is in (2, 2)
            int targetRow = (c - 'a') / 5;
            int targetCol = (c - 'a') % 5;
            
            int diffRow = targetRow - currRow;
            int diffCol = targetCol - currCol;
            
            // Try up first, because z only move up.
            if (diffRow < 0) {
                sb.append("U".repeat(-diffRow));
            }
            
            if (diffCol < 0) {
                sb.append("L".repeat(-diffCol));
            }
            
            if (diffCol > 0) {
                sb.append("R".repeat(diffCol));
            }
            
            if (diffRow > 0) {
                sb.append("D".repeat(diffRow));
            }
            
            sb.append("!");
            
            currRow = targetRow;
            currCol = targetCol;
        }
        
        return sb.toString();
    }
}
