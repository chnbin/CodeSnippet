class Car():
    def exclaim(self):
        print('I am a car')

class Yugo(Car):
        def exclaim(self):
            print('I am a Yugo')

a_car = Car()
a_Yugo = Yugo()
a_car.exclaim()
a_Yugo.exclaim()