function bitwiseComplement(N: number): number {
    // 17 = 010001 要變成補數其實讓010001與0111111XOR就可以
    // 0111111 可以由1000000 - 1得來
    // 1000000 為010001最左邊的1再往左一位 右邊全部填0
    if (N === 0) { return 1; }
    let target = N;
    let mask = 1;
    
    while (target > 0) {
        mask <<= 1;
        target = Math.floor(target/2);
    }
    
    return N ^ (mask - 1);
};

