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
const isValid = function (s) {
    if(!s) {
        return false
    }
    const bracketMaps = {
        "{": "}",
        "[": "]",
        "(": ")"
    }
    const leftBrackets = ["(", "[", "{"]
    // const rightBrackets = [")", "}", "]"]

    const stack = []
    for (let i in s) {
        const v = s[i]
        if(leftBrackets.includes(v)) {
            stack.push(v)
        } else {
            const peak = stack.pop()
            if(v !== bracketMaps[peak]) {
                return false
            }
        }
    }

    return stack.length <= 0;
}

console.log(isValid("{[[]}"))
