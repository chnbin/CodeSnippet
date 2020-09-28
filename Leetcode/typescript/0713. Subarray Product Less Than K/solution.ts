function numSubarrayProductLessThanK(nums: number[], k: number): number {
    let start: number = 0;
    let end: number = 0;
    let n: number = nums.length;
    let prod: number = 1;
    let res: number = 0;
    
    while (end < n) {
        prod *= nums[end];
        
        while (start < n && prod >= k) {
            prod = Math.floor(prod / nums[start]);
            start++;
        }
        
        res += (end - start + 1);
        end++;
    }
    
    return (res > 0) ? res : 0;
};
