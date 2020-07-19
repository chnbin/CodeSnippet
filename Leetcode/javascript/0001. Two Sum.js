/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let dict = {};
      
  for (let i = 0; i < nums.length; i++) {
      let value = target - nums[i];
      if (dict[value] !== undefined) {
          return [dict[value], i];
      } else {
          dict[nums[i]] = i;
      }
  }
};
