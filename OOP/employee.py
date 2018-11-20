class Employee:
    raise_rate = 1.05
    number_of_employee = 0

    def __init__(self, first, last, pay):
        self.first = first
        self.last = last
        self.pay = pay
        self.email = self.first+self.last+'@email.com'
        Employee.number_of_employee += 1

    def fullname(self):
        return '{} {}'.format(self.first, self.last)

    def raise_amount(self):
        self.pay = int(self.pay * Employee.raise_rate)

emp1 = Employee('Chen-Ping', 'Chang', 50000)
emp2 = Employee('Asuka', 'Inaba', 80000)

print(emp1.fullname())
print(emp2.fullname())

emp2.raise_amount()
print(emp2.pay)

# emp1 has no instance variable: raise_rate
print(emp1.__dict__)

# this raise_rate is class variable
print(emp1.raise_rate)

emp1.raise_rate = 1.06
print(emp1.__dict__)

print(emp1.raise_rate)
print(emp2.raise_rate)

print(emp1.number_of_employee)

emp3 = Employee('Author', 'Morgan', 100000)
print(emp1.number_of_employee)
