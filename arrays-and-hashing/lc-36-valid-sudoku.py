from collections import defaultdict
class Solution:
    def isValidSudoku(self, board) -> bool:
        row = defaultdict(set)
        col = defaultdict(set)
        grid = defaultdict(set)

        for i in range(9):
            for j in range(9):
                val = board[i][j]
                if val.isalnum():
                    k = i//3*3+j//3
                    if val in row[i] or val in col[j] or val in grid[k]:
                        return False
                    row[i].add(val)
                    col[j].add(val)
                    grid[k].add(val)
        return True  
                