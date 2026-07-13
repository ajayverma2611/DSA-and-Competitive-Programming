class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        int dl = 0;
        int dh = 0;

        int tmp = low;
        while (tmp != 0) {
            tmp = tmp / 10;
            dl++;
        }

        tmp = high;
        while (tmp != 0) {
            tmp = tmp / 10;
            dh++;
        }

        String s = "123456789";

        for (int i = 0; i < s.length(); i++) {
            for (int j = dl; j <= dh; j++) {
                if (i + j > s.length()) {
                    continue;
                }  

                String sub = s.substring(i, i + j);
                int val = Integer.parseInt(sub);

                if (low <= val && val <= high) {
                    ans.add(val);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}