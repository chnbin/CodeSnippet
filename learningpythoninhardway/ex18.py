# this one is like your scrips with argv
def print_two(*args):
    arg1, arg2 = args
    print ("arg1:%r, arg2:%r" %(arg1,arg2))

# ok, that *args is actually pointless,we can just do this
def print_two_again(arg1, arg2):
    print ("arg1:%r, arg2:%r" %(arg1,arg2))

# this function just take one argument
def print_one(arg1):
    print ("arg1:%r" % arg1)

# this function take no arguments
def print_none():
    print ("I got nothin'.")

print_two("ChenPin","Chang")
print_two_again("ChenPin","Chang")
print_one("Only One")

 # 新的python程式碼是不支援空白與tab混搭的
print_none()

    