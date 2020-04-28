class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            
            for (int j = 0; j < row.size(); j++) {
                list.add(new Node(i + j, i, row.get(j)));
            }
        }
         
        Collections.sort(list, (Node a, Node b) -> {
            if (a.sum == b.sum) {
                return b.row - a.row;
            }
            return a.sum - b.sum;
        });
        
        int[] res = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).value;
        }
        
        return res;
    }
}

class Node {
    public int sum;
    public int row;
    public int value;
    
    public Node(int sum, int row, int value) {
        this.sum = sum;
        this.row = row;
        this.value = value;
    }
}
