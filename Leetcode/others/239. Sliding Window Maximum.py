from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # 其實目標就是建立一個雙向對列，對列第一個數為第一大，第二數為第二大
        # deque存index歐
        
        # Corner case
        if not nums:
            return []
        if k == 1:
            return nums
        res = []
        deq = deque()
        
        # Find first k
        for i in range(k):
            while len(deq) != 0:
                # 只要目前的num大於deq的最後一個數，我們就把deq最後一個數擠掉
                # 因為我們要確保隊列第一個數為第一大，第二數為第二大
                if nums[i] > nums[deq[-1]]:
                    deq.pop()
                else:
                    break
            deq.append(i)
        
        # 由k遊歷到尾
        # 做四件事情
        for i in range(k, len(nums)):
            # print(deq)
            # 1.因為deque最左邊是最大值的index，所以我們加進去答案中
            res.append(nums[deq[0]])
            
            # 2.確定一下，目前deque最大值是否已經出界
            if i - k + 1 > deq[0]:
                deq.popleft()
            
            # 3.只要目前的num大於deq的最後一個數，我們就把deq最後一個數擠掉
            while len(deq) != 0:
                if nums[i] > nums[deq[-1]]:
                    deq.pop()
                else:
                    break
                    
            # 4.把index加到deque中 (3,4跟前面初始化是一樣的)
            deq.append(i)
                
        # 加入最後一個答案
        res.append(nums[deq[0]])
        return res
            