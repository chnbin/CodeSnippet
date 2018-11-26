class Solution(object):
  def findWordExtension(self, word):
    if not word:
      return []

    word = word.lower()
    res = []
    prev = None
    start = end = 0

    for i in range(0, len(word)):
      if not prev:
        start = i
        prev = word[i]
      elif prev == word[i]:
        end = i
      elif prev != word[i]:
        if (end - start + 1) > 2:
          res.append([start, end])
        prev = word[i]
        start = i
    
    if (len(word)-1 - start + 1) > 2:
      res.append([start, len(word)-1])
    
    return res

sol = Solution()

print(sol.findWordExtension('Hello'))
print(sol.findWordExtension('lllll'))
print(sol.findWordExtension('hellloooooooo'))
print(sol.findWordExtension('Heeeeelllooooooo'))
print(sol.findWordExtension('HeeeeelLlooooooo'))