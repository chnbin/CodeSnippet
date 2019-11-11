function reverseVowels(str) {
  let left = 0;
  let right = str.length - 1;
  let strList = Array.from(str);
  
  while (left < right) {
    while (!('aeiouAEIOU'.includes(strList[left]))) {
      left++;
    }
    
    while (!('aeiouAEIOU'.includes(strList[right]))) {
      right--;
    }
    let tmp = strList[left];
    strList[left] = strList[right];
    strList[right] = tmp;
    left++;
    right--;
  }
  
  return strList.join();
}

console.log(reverseVowels('Hello'));