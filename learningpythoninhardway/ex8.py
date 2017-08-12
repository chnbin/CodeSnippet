formatter = "%r %r %r %r"
formatter2 = "%d %d %s %s"
print (formatter % (1, 2, 3, 4))
print (formatter % ("One", "two", "three","four"))
print (formatter % (True,False,False,True))
print (formatter % (formatter , formatter, formatter, formatter))
print (formatter % (
    "I had this thing.",
    "That you could type up right.",
    "But it didn't sing.",
    "So I said goodnight."
))

# This will be wrong
# Var. are not matched
# print (formatter2 % (1, 2, 3, 4))

print (formatter2 % (1, 2, "3", "4"))