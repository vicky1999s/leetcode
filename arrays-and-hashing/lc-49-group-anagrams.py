from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs):
        cache = defaultdict(list)
        for word in strs:
            cache["".join(sorted(word))].append(word)
        return list(cache.values())
        
    
s = Solution()
strs = ["eat","tea","tan","ate","nat","bat"]
out = s.groupAnagrams(strs)
print(out)

        