from sys import argv

script, filename = argv

# 根據檔名打開檔案
txt = open(filename)
print ("Here's your file %r" % filename)

# 讀取file object的內容
# file object 的 method https://www.tutorialspoint.com/python/file_methods.htm
print (txt.read())

# 不使用file object就關掉 
txt.close()

print ("Type the filename again:")
file_again = input(">")
txt_again = open(file_again)

print (txt_again.read())
txt.close()