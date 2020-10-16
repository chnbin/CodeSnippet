/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
  let n = nums.length;
  k = k % n;
  reverse(nums, 0, n - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, n - 1);
};

function reverse(nums: number[], start: number, end: number): void {
  while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
  }
}

function swap(nums: number[], x: number, y: number): void {
  let tmp = nums[x];
  nums[x] = nums[y];
  nums[y] = tmp;
}