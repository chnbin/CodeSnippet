# 車子數量
cars = 100

# 一台車裡面可以坐幾人
space_in_a_car = 4

# 駕駛人數
drivers = 30

#乘客人數
passengers = 90

#不開的車子
cars_not_driven = cars - drivers

#有被開的車子
cars_driven = drivers

#這次運輸可以載的總人數
carpool_capacity = cars_driven * space_in_a_car

#這次運輸每台車子平均可以載客數
average_passengers_per_car = passengers / cars_driven

print ("There are",cars,"cars available.")
print ("There are only",drivers,"drivers available")
print ("There will be",cars_not_driven,"empty cars today.")
print ("我們每天可以載",carpool_capacity,"人")
print ("We have",passengers,"to carpool today")
print ("We need to put about" , average_passengers_per_car,"in each car")
