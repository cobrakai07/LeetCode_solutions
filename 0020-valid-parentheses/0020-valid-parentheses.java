class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == ')' || c == '}' || c == ']') {
                    if (c == ')') {

                        if (!stack.isEmpty() && stack.peek() == '(')
                            stack.pop();
                        else
                            return false;
                    }
                    if (c == ']') {

                        if (!stack.isEmpty() && stack.peek() == '[')
                            stack.pop();
                        else
                            return false;
                    }
                    if (c == '}') {

                        if (!stack.isEmpty() && stack.peek() == '{')
                            stack.pop();
                        else
                            return false;
                    }

                } else {
                    stack.push(c);
                }
            }
        }
        // System.out.println(stack);
        return stack.isEmpty();
    }
}