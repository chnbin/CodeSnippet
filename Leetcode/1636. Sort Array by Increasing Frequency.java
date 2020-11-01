class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        
        for (int num: nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        
        Info[] infos = new Info[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            infos[i] = new Info(nums[i], freqs.get(nums[i]));
        }
        
        Arrays.sort(infos, (a, b) -> {
            if (a.freq == b.freq) {
                return b.num - a.num;
            }
            return a.freq - b.freq;
        });
        
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = infos[i].num;
        }
        
        return res;
    }
}

class Info {
    int num;
    int freq;
    
    public Info (int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}