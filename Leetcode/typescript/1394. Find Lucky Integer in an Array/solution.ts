function findLucky(arr: number[]): number {
    let res: number = -1;
    let table: number[] = new Array(501).fill(0);
    
    arr.forEach((n) => {
        table[n]++;
    });
    
    for (let i = 500; i >= 1; i--) {
        if (table[i] === i) {
            return i;
        }
    }
    
    return res;
};

