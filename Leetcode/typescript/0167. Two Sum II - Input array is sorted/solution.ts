function twoSum(numbers: number[], target: number): number[] {
    let res: number[] = new Array(2).fill(0);
    let start: number = 0;
    let end: number = numbers.length - 1;
    
    while (start < end) {
        if (numbers[start] + numbers[end] === target) {
            res[0] = start + 1;
            res[1] = end + 1;
            return res;
        } else if (numbers[start] + numbers[end] < target) {
            start++;
        } else {
            end--;
        }
    }
    
    return res;
};
