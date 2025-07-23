class Solution {
    public int maximumGain(String s, int x, int y) {
        // Determine the order: remove higher value pair first
        String firstPair = x > y ? "ab" : "ba";
        int firstValue = Math.max(x, y);
        String secondPair = x > y ? "ba" : "ab";
        int secondValue = Math.min(x, y);

        // First pass: remove higher-value pairs
        String remaining = removePairs(s, firstPair.charAt(0), firstPair.charAt(1), firstValue);
        int total = pairRemovalPoints;

        // Second pass: remove lower-value pairs from the remaining string
        removePairs(remaining, secondPair.charAt(0), secondPair.charAt(1), secondValue);
        total += pairRemovalPoints;

        return total;
    }

    // Helper to store points earned in each pass
    private int pairRemovalPoints;

    // Function to remove all instances of a pair (like "ab" or "ba") from the string
    private String removePairs(String s, char first, char second, int value) {
        Stack<Character> stack = new Stack<>();
        pairRemovalPoints = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                pairRemovalPoints += value;
            } else {
                stack.push(c);
            }
        }

        // Reconstruct the remaining string after removals
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
