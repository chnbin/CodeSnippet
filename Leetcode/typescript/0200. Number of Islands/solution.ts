function numIslands(grid: string[][]): number {
    if (grid.length === 0 || grid[0].length === 0) {
        return 0;
    }

    let res: number = 0;
    let m: number = grid.length;
    let n: number = grid[0].length;
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '1') {
                res++;
                numIslandsHelper(grid, i, j);
            }
        }
    }
    
    return res;
};

function numIslandsHelper(grid: string[][], row: number, col: number) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
        return;
    }
    
    if (grid[row][col] === '0') {
        return;
    }
    
    grid[row][col] = '0';

    let directs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    
    for (let dir of directs) {
        let dx: number = row + dir[0];
        let dy: number = col + dir[1];
        numIslandsHelper(grid, dx, dy);
    }
}
