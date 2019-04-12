class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        queue = ['0000']
        visited = set()
        step = 0
        
        while queue:
            capacity = len(queue)
            
            for i in range(capacity):
                nowSlot = queue.pop(0)
                visited.add(nowSlot)
                
                if (nowSlot == target):
                    return step
                for j in range(0, len(nowSlot)):
                    for move in [-1, 1]:
                        digit = int(nowSlot[j])
                        digit = ((10 + digit + move) % 10)
                        nextSlot = self.getNextSlot(nowSlot, j, str(digit))
                        
                        if nextSlot not in deadends and nextSlot not in visited:
                            queue.append(nextSlot)
                            visited.add(nextSlot)
            step += 1
        return -1
    
    def getNextSlot(self, oldStr, index, char):
        newStr = ''
        
        for i in range(len(oldStr)):
            if i == index:
                newStr += char
            else:
                newStr += oldStr[i]
        return newStr

deadend = ["0201","0101","0102","1212","2002"]
target = "0202"
sol = Solution()
result = sol.openLock(['8888'], '0009')
print(result)