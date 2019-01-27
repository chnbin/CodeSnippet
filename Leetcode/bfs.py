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
    # 490 The Mazes
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
    # 529. Minesweeper
    def updateBoard(self, board, click):
        m = len(board)
        n = len(board[0])
        queue = [[click[0],click[1]]]
        queue = collections.deque()
        queue.append((click[0], click[1]))
        directs = [[-1,-1],[-1,1],[-1,0],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        
        while queue:
            point = queue.pop()
            x = point[0]
            y = point[1]
            
            if board[x][y] == "M":
                board[x][y] = "X"
            else:
                neibors = []
                mineCount = 0
                for direct in directs:
                    i = x + direct[0]
                    j = y + direct[1]
                    
                    if 0<=i<m and 0<=j<n:
                        neibors.append([i,j])
                        if board[i][j] == "M":
                            mineCount += 1
                if mineCount > 0:
                    board[x][y] = str(mineCount)
                else:
                    board[x][y] = "B"
                    for neibor in neibors:
                        if board[neibor[0]][neibor[1]] == "E":
                            queue.append([neibor[0],neibor[1]])
        return board
    
    # 542. 01 Matrix
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        # 同286一個pattern
        m = len(matrix)
        n = len(matrix[0])
        queue = []
        for i in range(0, m):
            for j in range(0, n):
                if matrix[i][j] != 0:
                    matrix[i][j] = 2**32 - 1
                else:
                    queue.append([i,j])
        for x,y in queue:
            for r,c in [[x+1,y],[x-1,y],[x,y+1],[x,y-1]]:
                dist = matrix[x][y] + 1
                if 0<=r<m and 0<=c<n and matrix[r][c] > dist:
                    matrix[r][c] = dist
                    queue.append([r,c])
        return matrix
    # 773. Sliding Puzzle
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        # 把初始板子換成一維list
        start = []
        for row in board:
            start += row
        
        # 這是要達到的狀態    
        goal = "123450"
        
        if ''.join(map(str,start)) == goal:
            return 0
        
        # 當0在某個位置，他可以交換的位置，例如0在4他可以和位置1,3,5換
        swap = [(1,3),(0,2,4),(1,5),(0,4),(1,3,5),(2,4)]
        
        steps = 0
        visited = set()
        q = collections.deque()
        q.append(start)
        
        while q:
            steps += 1
            
            # 要把目前延伸出去的全部做完才算一步
            qsize = len(q)
            while qsize>0:
                state = q.popleft()
                index = state.index(0)
                for direct in swap[index]:
                    state[index],state[direct] = state[direct],state[index]
                    newState = ''.join(map(str,state))
                    if newState not in visited:
                        if newState == goal:
                            return steps
                        q.append(state[::])
                        visited.add(newState)
                    state[index],state[direct] = state[direct],state[index]
                qsize -= 1
            
        return -1