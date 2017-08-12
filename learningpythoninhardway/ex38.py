
ten_tihngs ="Apple Oranges Crows Telephone Light Sugar"

print ("Wait there are not 10 things in the list.Let's fix that.")

stuff = ten_tihngs.split(" ")
more_stuff = ["Day","night","Song","Frisbee","Corn","Banana","Girl","Boy"]

while len(stuff) != 10:
    next_one = more_stuff.pop()
    print ("Adding: ", next_one)
    stuff.append(next_one)
    print ("There are %d things now." % len(stuff))

print ("There we go: ", stuff)

print ("Let's do some things with stuff.")

print (stuff[1])
print (stuff[-1])
# print (stuff.pop())
# print (stuff)
print (" ".join(stuff))
print (stuff)
print ("-".join(stuff))
print (stuff)
print ("#".join(stuff[3:5]))
