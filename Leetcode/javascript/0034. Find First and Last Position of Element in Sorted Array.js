/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  let res = [-1, -1];
  res[0] = bsFirstPostion(nums, target);
  res[1] = bsLastPositon(nums, target);
  
  return res;
};

let bsFirstPostion = (nums, target) => {
  let res = -1;
  let left = 0;
  let right = nums.length - 1;
  
  while (left <= right) {
      let m = (left) + parseInt((right - left) / 2);
      
      if (nums[m] === target) {
          res = m;
          right = m - 1;
      } else if (nums[m] > target) {
          right = m - 1;
      } else {
          left = m + 1;
      }
  }
  
  return res;
}

let bsLastPositon = (nums, target) => {
  let res = -1;
  let left = 0;
  let right = nums.length - 1;
  
  while (left <= right) {
      let m = (left) + parseInt((right - left) / 2);
      
      if (nums[m] === target) {
          res = m;
          left = m + 1;
      } else if (nums[m] > target) {
          right = m - 1;
      } else {
          left = m + 1;
      }
  }
  
  return res;
}
