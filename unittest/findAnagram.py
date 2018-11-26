class Solution(object):
	def __init__(self):
		pass
	
	def findAnagram(self, word, words):
		if (not word or not words):
			return []

		res = []

		wordCode = self.computeWordCode(word)

		for word in words:
			if wordCode == self.computeWordCode(word):
				res.append(word)
		
		return res
	
	def computeWordCode(self, word):
		wordCode = [0]*26

		for char in word.lower():
			wordCode[ord(char)-ord('a')] += 1
		
		return wordCode

