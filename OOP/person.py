class Person():
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return self.name

class MDPerson(Person):
    def __init__(self, name):
        self.name = 'Doctor ' + name

    def __str__(self):
        return 'MDPerson ' + self.name

class Gunslinger(Person):
    def __init__(self, name):
        self.name = 'Gunslinger ' + name
    
    def __str__(self):
        return self.name
    
man = Person('Chen-Ping')
print(man)

mdPerson = MDPerson('Asuka Inabe')
print(mdPerson)

gunslinger = Gunslinger('Author Morgan')
print(gunslinger)