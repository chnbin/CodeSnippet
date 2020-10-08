function mySqrt(x: number): number {
    let res: number = 0;
    let left: number = 1;
    let right: number = x;
    
    while (left <= right) {
        let mid: number = left + Math.floor((right - left) / 2);
        
        if (mid * mid === x) {
            return mid;
        }
        
        if (mid * mid > x) {
            right = mid - 1;
        } else {
            res = mid;
            left = mid + 1;
        }
    }
    
    return res;
};

