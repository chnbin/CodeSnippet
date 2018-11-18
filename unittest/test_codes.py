import unittest
from solution import Solution

class TestCodes(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()
    
    def test_vaildMountainArray(self):
        self.assertEqual(self.sol.vaildMountainArray([1,3,2]), True)
        self.assertEqual(self.sol.vaildMountainArray([0,3,2,1]), True)
        self.assertEqual(self.sol.vaildMountainArray([]), False)
        self.assertEqual(self.sol.vaildMountainArray([2,1]), False)
        self.assertEqual(self.sol.vaildMountainArray([3,5,5]), False)
        self.assertIs(self.sol.vaildMountainArray([]), False)
        self.assertTrue(self.sol.vaildMountainArray([1,3,2]))
if __name__ == '__main__':
    unittest.main() 