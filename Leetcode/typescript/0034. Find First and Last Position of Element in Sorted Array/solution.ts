function searchRange(nums: number[], target: number): number[] {
    let firstIndex: number = findFirstIndex(nums, target);
    let lastIndex: number = findLastIndex(nums, target);
    return [firstIndex, lastIndex];
};

function findFirstIndex(nums: number[], target: number): number {
    let index: number = -1;
    let left: number = 0;
    let right: number = nums.length - 1;
    
    while (left <= right) {
        let mid: number = left + Math.floor((right - left) / 2);
        
        if (nums[mid] === target) {
            index = mid;
            right = mid - 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid -1;
        }
    }
    
    return index;
}

function findLastIndex(nums: number[], target: number): number {
    let index: number = -1;
    let left: number = 0;
    let right: number = nums.length - 1;
    
    while (left <= right) {
        let mid: number = left + Math.floor((right - left) / 2);

        if (nums[mid] === target) {
            index = mid;
            left = mid + 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return index;
}

