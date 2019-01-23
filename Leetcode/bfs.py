class Solution(object):
    def levelOrder(self, root):
        """
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def levelOrderHelper(node, level, ans):
            if node:
                if len(ans) < (level+1):
                    ans.append([])
                ans[level].append(node.val)
                levelOrderHelper(node.left, level+1, ans)
                levelOrderHelper(node.right, level+1, ans)
                
        if not root:
            return []
        ans = []
        levelOrderHelper(root, 0, ans)
        return ans

    def levelOrderBottom(self, root):
        """
        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def levelOrderBottomHelp(node, level, ans):
            if node:
                if len(ans) < level + 1:
                    ans.insert(0,[])
                ans[-(level+1)].append(node.val)
                levelOrderBottomHelp(node.left, level+1, ans)
                levelOrderBottomHelp(node.right, level+1, ans)
        if not root:
            return []
        ans = []
        levelOrderBottomHelp(root, 0, ans)
        return ans

    def validTree(self, n, edges):
        """
        https://leetcode.com/problems/graph-valid-tree/
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        group = [i for i in range(n)]
        
        for edge in edges:
            v,w = edge
            pId = group[v]
            qId = group[w]
            
            if pId != qId:
                for j in range(0, len(group)):
                    if group[j] == pId:
                        group[j] = qId
            else:
                return False
        s = set(group)
        
        if len(s) == 1:
            return True
        else:
            return False

    def numSquares(self, n):
        """
        https://leetcode.com/problems/perfect-squares/
        :type n: int
        :rtype: int
        """
        squares = [i**2 for i in range(1, int(math.sqrt(n))+1)]
        # print(squares)
        queue = [0]
        level = 1
        
        while True:
            nextLevel = []
            for c in queue:
                for s in squares:
                    total = c + s
                    if total == n:
                        return level
                    if total < n:
                        nextLevel.append(total)
            level += 1
            queue = set(nextLevel)
        return level

    def shortestDistance(self, grid):
        """
        https://leetcode.com/problems/shortest-distance-from-all-buildings/
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        self.nth = -1
        self.ans = float('inf')
        
        distance = [[0]* n for i in range(m)]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    if self.bfs(i, j, grid, distance) is False:
                        return -1
                
        return self.ans
    
    def bfs(self, i, j, grid, distance):
        m = len(grid)
        n = len(grid[0])
        
        queue = [(i, j)]
        nth = self.nth
        level = 1
        
        count = 0
        self.ans = float('inf')
        while queue:
            for i in range(len(queue)):
                x, y = queue.pop(0)
                for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                    nextx = x+dx
                    nexty = y+dy
                    if 0<= nextx <m and 0<=nexty<n and grid[nextx][nexty] == (nth+1):
                        count+=1
                        queue.append((nextx, nexty))
                        distance[nextx][nexty] += level
                        self.ans = min(self.ans, distance[nextx][nexty])
                        grid[nextx][nexty] = nth
            level += 1
                
            
        self.nth -= 1
        
        return True if count != 0 else False

    def canFinish(self, numCourses, prerequisites):
        """
        https://leetcode.com/problems/course-schedule/
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        inDegree = [0]*numCourses
        graph = collections.defaultdict(list)
        queue = []
        res = []
        
        for pair in prerequisites:
            pre = pair[1]
            course = pair[0]
            inDegree[course] += 1
            graph[pre].append(course)
        
        for idx, degree in enumerate(inDegree):
            if degree == 0:
                queue.append(idx)
                
        while queue:
            course = queue.pop(0)
            res.append(course)
            
            for node in graph[course]:
                inDegree[node] -= 1
                if inDegree[node] == 0:
                    queue.append(node)
        
        return len(res) == numCourses
    def wallsAndGates(self, rooms):
        """
        https://leetcode.com/problems/walls-and-gates/
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        if rooms:
            m = len(rooms)
            n = len(rooms[0])
            queue = []

            queue = [(i, j) for i in range(m) for j in range(n) if rooms[i][j] == 0]

            for (x,y) in queue:
                for dx, dy in [[0,1], [0,-1], [1,0], [-1,0]]:
                    if (0<= x + dx < m) and (0<= y + dy < n):
                        dist = rooms[x][y] + 1
                        if dist < rooms[x+dx][y+dy]:
                            rooms[x+dx][y+dy] = dist
                            queue.append((x+dx, y+dy))

    def hasPath(self, maze, start, destination):
        """
        https://leetcode.com/problems/the-maze/
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        queue = [[start[0],start[1]]]
        m = len(maze[0])
        n = len(maze)
        
        while queue:
            point = queue.pop(0)
            posX = point[0]
            posY = point[1]
            if posX == destination[0] and posY == destination[1]:
                return True
            maze[posX][posY] = -1 #visited
            for direction in directions:
                row = posX + direction[0]
                col = posY + direction[1]
                
                while (0<=row<n and 0<=col<m and maze[row][col] != 1):
                    row += direction[0]
                    col += direction[1]
                row -= direction[0]
                col -= direction[1]
                if maze[row][col]==0:
                    queue.append([row,col])
        return False