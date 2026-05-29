class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans[] = new int[58];

        for (char c : word.toCharArray()) {
            ans[c - 'A']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (ans[i] != 0 && ans[i + 32] != 0) {
                cnt++;
            }
        }

        return cnt;
    }
}