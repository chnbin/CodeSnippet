class Solution {
    public String arrangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, (a, b) -> a.length() - b.length());
        String res = String.join(" ", s);
        return Character.toUpperCase(res.charAt(0)) + res.substring(1);
    }
}
