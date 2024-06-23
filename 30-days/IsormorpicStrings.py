"""
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Input: s = "egg", t = "add"
Output: true
"""

def isIsomorphic(s, t):
    map_s_t = {}
    map_t_s = {}
    for c1, c2 in zip(s, t):
        if c1 not in map_s_t and c2 not in map_t_s:
            map_s_t[c1] = c2
            map_t_s[c2] = c1
            
        elif map_s_t.get(c1) != c2 or map_t_s.get(c2) != c1:
            return False

    return True

s = 'badc'
t = 'baba'
print(isIsomorphic(s,t))
