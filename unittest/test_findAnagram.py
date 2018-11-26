import unittest
from findAnagram import Solution

class TestCodes(unittest.TestCase):
	def setUp(self):
		self.sol = Solution()

	def test_testAnagram(self):
		# ["eat", "tea", "tan", "ate", "nat", "bat"]
		self.assertEqual(self.sol.findAnagram("", ["eat", "tea", "tan", "ate", "nat", "bat"]), [])
		self.assertEqual(self.sol.findAnagram("", []), [])
		self.assertEqual(self.sol.findAnagram("eat", ["eat", "tea", "tan", "ate", "nat", "bat"]), ["eat", "tea", "ate"])
		self.assertEqual(self.sol.findAnagram("tea", ["eat", "tea", "tan", "ate", "nat", "bat"]), ["eat", "tea", "ate"])
		self.assertEqual(self.sol.findAnagram("tab", ["eat", "tea", "tan", "ate", "nat", "bat"]), ["bat"])
	
if __name__ == '__main__':
	print("Start")
	unittest.main()
