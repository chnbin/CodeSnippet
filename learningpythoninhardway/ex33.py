def gatherNumbers(count):
    i = 0
    numbers = []
    while i < count:
        print ("At the top i is %d" % i)
        numbers.append(i)
        i=i + 1
        print ("Number now:", numbers)
        print ("At the bottom i is %d" % i)
    return numbers


numbers = gatherNumbers(71)

print ("Print the numbers: ")

for num in numbers:
    print (num)