class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {"(":")", "[":"]", "{":"}"}
        stack = []
        for char in s:
            if char in brackets:
                stack.append(char)
            else:
                if char != brackets[stack.pop()]:
                    return False 
        return True