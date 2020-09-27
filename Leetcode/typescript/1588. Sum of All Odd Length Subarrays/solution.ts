function sumOddLengthSubarrays(arr: number[]): number {
    let res: number = 0;
    
    const n: number = arr.length;
    
    for (let i = 0; i < n; i++) {
        let sum: number = arr[i];
        let cnt: number = 1;
        res += sum;

        for (let j = i + 1; j < n; j++) {
            cnt++;
            sum += arr[j];
            if (cnt % 2 == 1) {
                res += sum;
            }
        }
    }
    
    
    return res;
};
