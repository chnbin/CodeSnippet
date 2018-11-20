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
    
    def __str__(self):
        return '{} {} {}'.format(self.first, self.last, self.pay)

    @classmethod
    def set_raise_rate(cls, rate):
        cls.raise_rate = rate
    
    @classmethod
    def get_Emp_form_string(cls, str):
        first, last, pay = str.split('-')
        return cls(first, last, pay)

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

# class method example
Employee.set_raise_rate(1.06)
print(emp1.raise_rate)
print(emp2.raise_rate)

# Take class method as alternative constructor
empString = 'John-Doe-10000'
emp4 = Employee.get_Emp_form_string(empString)
print(emp4)


