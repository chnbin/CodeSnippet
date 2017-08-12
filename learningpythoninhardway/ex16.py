from sys import argv

script, filename = argv

print ("We're going to erase %r." % filename)
print ("If you don't want to do that , press Ctrl - C.")
print ("If you do want to erase, press Enter.")

input("?")

print ("Opening the file...")

# 將檔案以write模式開啟，其實用write開啟的同時，這個file就被truncate了
target = open(filename, 'w')

# 以下會報錯，因為此時not readable
# print(target.read())

# 其實不需要以下兩行了
print ("Truncating the file.")
target.truncate()

print ("Now I am going to ask you for three lines.")
line1 = input("line 1:")
line2 = input("line 2:")
line3 = input("line 3:")

print ("I'm going to write these to the file.")
target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)
target.write("\n")

print ("And finally , we close it.")
target.close()
