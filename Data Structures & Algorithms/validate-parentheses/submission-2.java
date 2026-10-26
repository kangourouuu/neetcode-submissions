class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        Character popped = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    popped = stack.pop();
                } else
                    return false;
                if (s.charAt(i) == ']' && popped != '[' || s.charAt(i) == '}' && popped != '{'
                        || s.charAt(i) == ')' && popped != '(') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}
