class Solution {
    int dp[];

    public int totalWaviness(int num1, int num2) {
        int cnt = 0;

        if (num2 <= 100) {
            return cnt;
        }

        for (int i = num1; i <= num2; i++) {
            if (i > 100) {
                String num = String.valueOf(i);

                for (int j = 1; j < num.length() - 1; j++) {
                    if ((num.charAt(j - 1) - '0') < (num.charAt(j) - '0')
                            && (num.charAt(j + 1) - '0') < (num.charAt(j) - '0')) {
                        cnt++;
                    }
                    if ((num.charAt(j - 1) - '0') > (num.charAt(j) - '0')
                            && (num.charAt(j + 1) - '0') > (num.charAt(j) - '0')) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}