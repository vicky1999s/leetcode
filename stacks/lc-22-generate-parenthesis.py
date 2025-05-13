class Solution:
    def generateParenthesis(self, n: int):
        self.result = []
        
        def recurse(open, close, curr):
            if len(curr) == n*2:
                self.result.append(curr)
                return
            if open<n:
                recurse(open+1, close, curr+"(")
            if close<open and close<n:
                recurse(open, close+1, curr+")")
        recurse(0, 0, "")
        return self.result

S = Solution()
print(S.generateParenthesis(3))


        