# http://acm.timus.ru/problem.aspx?space=1&num=1296

number = int(input())

intensity = []
i = 0
while i < number:
    element = int(input())
    intensity.append(element)
    i = i + 1

gravitypotential = 0

maxpotential = 0

for potential in intensity:
    gravitypotential = gravitypotential + potential
    if gravitypotential > 0:
        if gravitypotential > maxpotential:
            maxpotential = gravitypotential
    else:
        gravitypotential = 0

print (maxpotential)