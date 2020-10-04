function combinationSum(candidates: number[], target: number): number[][] {
    let res: number[][] = [];
    let currSet: number[] = [];
    candidates.sort();
    combinationSumHelper(candidates, 0, candidates.length, currSet, res, target);
    return res;
};

function combinationSumHelper(
    nums: number[],
    start: number,
    end: number,
    curr: number[],
    res: number[][],
    target: number): void{
    if (target == 0) {
        res.push(curr.slice(0));
        return;
    }
        
    for (let i = start; i < end; i++) {
        if (target >= nums[i]) {
            curr.push(nums[i]);
            target -= nums[i];
            combinationSumHelper(nums, i, end, curr, res, target);
            target += nums[i];
            curr.pop();
        }
    }
}
