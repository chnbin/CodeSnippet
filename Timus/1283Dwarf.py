# http://acm.timus.ru/problem.aspx?space=1&num=1283

i, n, c = input().split(" ")

initialmoney = float(i)
nosense = float(n)
commissionrate = float(int(c)/100)

# print ("%f %f %f" % (initialmoney, nosense, commissionrate))

if initialmoney < nosense:
    print ("0")
else:
    year = 0

    while initialmoney > nosense:
        commission = initialmoney * commissionrate
        initialmoney = initialmoney - commission
        # print("Commision of %d year is %f and %f is left." % (year, commission, initialmoney))
        year = year +1
    
    print(year)
