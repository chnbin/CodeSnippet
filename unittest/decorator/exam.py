class Exam(object):
    def __init__(self, score):
        self._score  = score
    
    def get_score(self):
        return self._score

    def set_score(self, val):
        if val < 0:
            self._score = 0
        elif val > 100:
            self._score = 100
        else:
            self._score = val