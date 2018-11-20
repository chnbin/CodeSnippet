
def square(num):
    return num*num

print(square(5))

func = square
print(func)

def my_map(func, arg_list):
    result = []

    for arg in arg_list:
        result.append(func(arg))
    
    return result

print(my_map(func, [0,1,2,3,4,5,6,7,8,9]))


def html_tag(tag):
    def warp_Text(msg):
        print('<{0}>{1}</{0}>'.format(tag, msg))
    return warp_Text

warpH1 = html_tag('H1')
warpH1('RDR2 is a great game.')
warpH1('West life simulator.')

warpP = html_tag('p')
warpP('RDR2 is a great game.')
warpP('West life simulator.')