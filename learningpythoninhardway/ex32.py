the_count = [1, 2, 3, 4, 5]
fruits = ['apples','oranges','pears','acricots']
change = [1, 'pennies', 2, 'dimes', 3, 'quarters']

for number in the_count:
    print ("This is count %d" % number)

for fruit in fruits:
    print ("The furit type %s" % fruit)

for i in change:
    print ("I got %r" % i)

elements = []

# 從0開始，共6個
for i in range(0,6):
    print ("Adding %d to the list." % i)
    elements.append(i)

for element in elements:
    print ("Element was %d" % element)

lists = []
the_count = input("Input a list likes 1 3 45 23:").split(" ")


for number in the_count:
    print ("%d will be appended to list" % int(number))
    lists.append(int(number))

for i in lists:
    print ("List was %d" % i)