import java.util.*;

/**
 * @ title: 有效的括号
 * @ author WangXin
 * @ date 2023/5/29 9:43
 * @ description: 给定一个只包括 '(',')','{','}','[',']' 的字符串,判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class 有效的括号 {

    public static void main( String[] args ) {

        System.out.println(isValid("}{[]}"));
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        Map<String, String> bracketMaps = new HashMap<>();
        bracketMaps.put("(",")");
        bracketMaps.put("{","}");
        bracketMaps.put("[","]");

        Set<String> leftBrackets = new HashSet<>(Arrays.asList("(", "{", "["));
        Set<String> rightBrackets = new HashSet<>(Arrays.asList(")", "}", "]"));

        LinkedList<String> stack = new LinkedList<>();
        String[] arr = s.split("");
        for (String value : arr) {
            if (leftBrackets.contains(value)) {
                stack.add(value);
            } else if (rightBrackets.contains(value)) {
                if(stack.size() == 0 || !value.equals(bracketMaps.get(stack.removeLast()))) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

}
