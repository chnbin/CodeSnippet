/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 * @param {number} A
 * @param {number} B
 * @return {string}
 */
var strWithout3a3b = function(A, B) {
  if (A == 0) {
      return 'b'.repeat(B);
  } else if (B == 0) {
      return 'a'.repeat(A);
  } else if (A == B) {
      return 'ab' + strWithout3a3b(A - 1, B - 1);
  } else if (A > B) {
      return 'aab' + strWithout3a3b(A - 2, B - 1);
  } else {
      return strWithout3a3b(A - 1, B - 2) + 'abb';
  }
};