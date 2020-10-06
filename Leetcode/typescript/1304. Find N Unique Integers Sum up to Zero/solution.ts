function sumZero(n: number): number[] {
    let res: number[] = new Array(n).fill(0);
    
    for (let i = 0; i < Math.floor(n / 2); i++) {
        res[i] = - Math.floor(n / 2) + i;
        res[n - i - 1] = Math.abs(res[i]);
    }
    
    return res;
};

