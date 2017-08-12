from sys import argv
from os.path import exists

script, from_file, to_file = argv

print ("Copy from %s to %s" % (from_file,to_file))

# We can combine there two line into one line, how?
# 這種一行的版本在執行完的時候就會關閉了
indata = open(from_file).read()
# in_file = open(from_file)
# indata = in_file.read()

print ("The input files is %d bytes long." % len(indata))

print ("Dose the output file exist? %r" %exists(to_file))
print ("Ready, press Enter to continue, Ctrl + C to abort.")
input()

out_file = open(to_file,'w')
out_file.write(indata)

print ("Alright, all done.")
out_file.close()
# in_file.close()