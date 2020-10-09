class Solution {
    public boolean isValidSerialization(String preorder) {
        /*
            觀察多個合法的案例，其實會發現有兩個規則:
            1. # 一定比數字多一個。
            2. 最後一個一定是#
            因此扣除最後一個字元#, 數字與#的數量應該相等
        */
        int cnt = 0;
        String[] nodes = preorder.split(",");
        
        for (int i = 0; i < nodes.length - 1; i++) {
            if (nodes[i].equals("#")) {
                if (cnt == 0) {
                    return false;
                }
                cnt++;
            } else {
                cnt--;
            }
        }
        
        return cnt == 0 && (preorder.charAt(preorder.length() - 1) == '#');
    }
}
