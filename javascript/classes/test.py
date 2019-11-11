def front_back(str):
  strList = list(str)
  strList[0], strList[-1] = strList[-1], strList[0]
  return ''.join(strList)

c = front_back('');
print(c)