from exam import Exam
from examWithProperty import ExamWithProperty
e = Exam(60)

print(e.get_score())

e.set_score(70)

print(e.get_score())

e = ExamWithProperty(60)

print(e.score)

e.score = 70

print(e.score)