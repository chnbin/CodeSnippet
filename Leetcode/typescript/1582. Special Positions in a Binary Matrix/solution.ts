function numSpecial(mat: number[][]): number {
    let res: number = 0;
    const m: number = mat.length;
    const n: number = mat[0].length;
    let rows: number[] = new Array(m).fill(0); // Default value is NaN.
    let cols: number[] = new Array(n).fill(0);
    
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1) {
                rows[i]++;
                cols[j]++;
            }
        }
    }
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1 && rows[i] === 1 && cols[j] === 1) {
                res++;
            }
        }
    }
    
    return res;
};
