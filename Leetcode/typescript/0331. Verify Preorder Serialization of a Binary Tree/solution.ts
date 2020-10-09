function isValidSerialization(preorder: string): boolean {
    /*
        觀察多個合法的案例，其實會發現有兩個規則:
        1. # 一定比數字多一個。
        2. 最後一個一定是#
        因此扣除最後一個字元#, 數字與#的數量應該相等
    */
    let cnt: number = 0;
    let n: number = preorder.length - 1;
    let nodes: string[] = preorder.split(",");
    
    for (let i = 0; i < nodes.length - 1; i++) {
        if (nodes[i] === "#") {
            if (cnt == 0) {
                return false;
            }
            cnt++;
        } else {
            cnt--;
        }
    }
    
    return cnt == 0 && (preorder[n] === "#");
};

