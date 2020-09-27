function plusOne(digits: number[]): number[] {
    let carry: number = 1;
    let n: number = digits.length - 1;
    
    for (let i = n; i >= 0; i--) {
        let currSum = digits[i] + carry;
        digits[i] = currSum % 10;
        carry = Math.floor(currSum / 10);
    }
    
    if (carry === 1) {
        // array.splice(start[, deleteCount[, item1[, item2[, ...]]]])
        // Insert variable carry in index 0 of digits and delete 0 element.
        digits.splice(0, 0, carry);
    }
    
    return digits;
};
