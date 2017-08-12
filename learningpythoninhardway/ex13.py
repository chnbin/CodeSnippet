from sys import argv
# 要解包的個數
print (len(argv))
count = len(argv)

if count == 4:
#if要空，你把下面註解取消就會錯
#script, first, second, third = argv     
    script, first, second, third = argv
    print ("The script is called:",script)
    print ("Your first var. is:", first)
    print ("Your second var is:", second)
    print ("Your third var is:", third)
else:
    print ("Need argv")
    