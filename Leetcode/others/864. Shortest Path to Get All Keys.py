class Solution(object):
    def shortestPathAllKeys(self, grid):
        """
        https://leetcode.com/problems/shortest-path-to-get-all-keys/
        :type grid: List[str]
        :rtype: int
        """
        M = len(grid)
        N = len(grid[0])

        # 所有的鑰匙
        keys = 'abcdef'

        # 可以走的地板，會隨著獲得新的鑰匙擴充，例如拿到a鑰匙，字串會變成'@.abcdefA'
        canWalk = '@.abcdef'

        # 地圖需要拿的鑰匙數量，是結束條件
        keyCount = 0

        # 紀錄已經得到的鑰匙數量
        keyGot = 0

        queue = []
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visited = set()
        startPoint = []

        # 找出出發點，並且掃描整個迷宮共有幾隻鑰匙要拿
        for i in range(M):
            for j in range(N):
                if grid[i][j] in '@':
                    startPoint = [i, j]
                    continue
                if grid[i][j] in keys:
                    keyCount += 1
        
        # Queue存放的依次是 座標x軸 座標y軸 目前步數 目前可以走哪些地板  目前已經獲得幾把鑰匙
        queue.append([startPoint[0], startPoint[1], 0, canWalk, keyGot])
        
        while queue:
            capacity = len(queue)
            
            for i in range(capacity):
                x, y, step, canWalk, keyGot = queue.pop(0)
                visited.add(str(x) + '-' + str(y) + '-' + canWalk)

                # 如果這格地板是鑰匙，更新獲得鑰匙數量，並且擴充canWalk
                if (grid[x][y] in keys and grid[x][y].upper() not in canWalk):
                    keyGot += 1
                    canWalk += grid[x][y].upper()
                
                # 如果得到全部鑰匙，就結束
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
                