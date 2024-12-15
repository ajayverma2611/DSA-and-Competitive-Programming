import java.util.*;
import java.io.*;

class infix_to_prefix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());  // Read the number of test cases
        while (t-- > 0) {
            String expression = br.readLine().trim();   // Read the infix expression as a string
            System.out.println(new Solution().infixToPrefix(expression));
        }
    }
}

class Solution {
    // Function to convert an infix expression to a prefix expression.
    
    // Helper method to determine operator precedence.
    public static int priority(char a) {
        if (a == '^') {
            return 3;
        } else if (a == '*' || a == '/') {
            return 2;
        } else if (a == '+' || a == '-') {
            return 1;
        }
        return -1;
    }

    public static String infixToPrefix(String eexp) {

        // Reverse the input string to start the conversion.
        StringBuilder exp = new StringBuilder(eexp).reverse();
        char ch;

        // Invert parentheses in the reversed string.
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                exp.setCharAt(i, ')');
            } else if (exp.charAt(i) == ')') {
                exp.setCharAt(i, '(');
            }
        }

        // Perform infix to postfix conversion on the modified string.
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int l = exp.length();

        for (int i = 0; i < l; i++) {
            char curr = exp.charAt(i);

            // Append operands (letters and digits) directly to the result.
            if (Character.isLetterOrDigit(curr)) {
                ans.append(curr);
            } 
            // Push '(' to stack
            else if (curr == '(') {
                st.push('(');
            } 
            // Process ')' and pop until '(' is encountered
            else if (curr == ')') {
                while (!st.empty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();  // Pop '('
            } 
            // Process operators
            else {
                while (!st.empty() && priority(curr) < priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(curr);
            }
        }

        // Pop remaining operators from the stack
        while (!st.empty()) {
            ans.append(st.pop());
        }

        // Reverse the final postfix expression to get prefix
        return ans.reverse().toString();
    }
}
