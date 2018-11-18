class Solution(object):
    def vaildMountainArray(self, A):
        """
        Leetcode 941. Valid Mountain Array.
        Problem description is https://leetcode.com/problems/valid-mountain-array/description/
        :type A: List[int]
        :rtype: bool
        """
        if not A or len(A) < 3:
            return False
        
        left = 0
        right = len(A) - 1
        
        # climb to right
        while left + 1 < len(A) and A[left] < A[left+1]:
            left += 1
        
        # climb to left
        while right - 1 > 0 and A[right] < A[right-1]:
            right -= 1
        
        return left == right and left != 0 and right != len(A) - 1 