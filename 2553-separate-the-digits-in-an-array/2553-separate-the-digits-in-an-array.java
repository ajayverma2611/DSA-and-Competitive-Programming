import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        for (int num : nums) {
            tmp.append(num);
        }

        for (char c : tmp.toString().toCharArray()) {
            list.add(c - '0');
        }

        int[] ans = new int[list.size()];

        int i = 0;
        for (int n : list) {
            ans[i] = n;
            i++;
        }

        return ans;
    }
}