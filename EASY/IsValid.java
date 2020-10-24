package top.nzhz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

//        Map<Character, Character> pairs = new HashMap<Character, Character>();
//        pairs.put('(', ')');
//        pairs.put('[', ']');
//        pairs.put('{', '}');

//
        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        LinkedList<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || pairs.get(ch) != stack.peek())
                    return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
