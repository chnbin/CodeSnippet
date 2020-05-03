class Solution {
    public String destCity(List<List<String>> paths) {
        String res = "";
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            if (!set.contains(path.get(0))) {
                set.add(path.get(0));
            }
        }
        
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            if (!set.contains(path.get(1))) {
                res = path.get(1);
                break;
            }
        }
        
        return res;
    }
}
