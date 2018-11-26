import unittest
from wordExtension import Solution

class TestWordExtension(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def testWordExtension(self):
        self.assertEqual(self.sol.findWordExtension(''), [])
        self.assertEqual(self.sol.findWordExtension('lllll'), [0,4])
        self.assertEqual(self.sol.findWordExtension('Hello'), [])
        self.assertEqual(self.sol.findWordExtension('hellloooooooo'), [[2,4], [5,12]])
        self.assertEqual(self.sol.findWordExtension('Heeeeelllooooooo'), [[1, 5], [6, 8], [9, 15]])
        self.assertEqual(self.sol.findWordExtension('HeeeeellloOOOOOo'), [[1, 5], [6, 8], [9, 15]])

if __name__ == '__main__':
    unittest.main()
