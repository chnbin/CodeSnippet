function isPerfectSquare(num: number): boolean {
    let left: number = 1;
    let right: number = num;
    
    while (left <= right) {
        let mid: number = left + Math.floor((right - left) / 2);
        
        if (mid * mid === num) {
            return true;
        }
        
        if (mid * mid > num) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    return false;
};

