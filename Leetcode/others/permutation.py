def permutationHelper(nums, start, end, ans):
  if (start == end):
    ans.append(list(nums))
  else:
    for i in range(start, end):
      nums[i], nums[start] = nums[start], nums[i]
      permutationHelper(nums, start + 1, end, ans)
      nums[i], nums[start] = nums[start], nums[i]

def permutation(nums, ans):
  permutationHelper(nums, 0, len(nums), ans)
  return ans

print(permutation([1,2,3], []))