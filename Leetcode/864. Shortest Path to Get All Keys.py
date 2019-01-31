class Solution(object):
    def shortestPathAllKeys(self, grid):
        """
        https://leetcode.com/problems/shortest-path-to-get-all-keys/
        :type grid: List[str]
        :rtype: int
        """
        M = len(grid)
        N = len(grid[0])
        keys = 'abcdef'
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        canWalk = '@.abcdef'
        startPoint = []
        keyCount = 0
        keyGot = 0
        queue = []
        visited = set()

        for i in range(M):
            for j in range(N):
                if grid[i][j] in '@':
                    startPoint = [i, j]
                    continue
                if grid[i][j] in keys:
                    keyCount += 1
        
        queue.append([startPoint[0], startPoint[1], 0, canWalk, keyGot])
        
        while queue:
            capacity = len(queue)
            
            for i in range(capacity):
                x, y, step, canWalk, keyGot = queue.pop(0)
                visited.add(str(x) + '-' + str(y) + '-' + canWalk)

                if (grid[x][y] in keys and grid[x][y].upper() not in canWalk):
                    keyGot += 1
                    canWalk += grid[x][y].upper()

                if (keyGot == keyCount):
                    return step

                for direction in directions:
                    dx, dy = direction
                    newX = x + dx
                    newY = y + dy
                    newPos = str(newX) + '-' + str(newY) + '-' + canWalk
                    if (0 <= newX < M) and (0 <= newY < N) and (grid[newX][newY] in canWalk) and (newPos not in visited):
                        visited.add(newPos)
                        queue.append([newX, newY, step + 1, canWalk, keyGot])
        
        return -1
                