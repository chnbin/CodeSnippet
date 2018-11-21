import logging
logging.basicConfig(filename='example.log', level=logging.INFO,format='%(asctime)s %(name)s %(levelname)s %(message)s')

def logger(func):
    def log_Func(*args):
        logging.info('Running {} with args: {}.'.format(func.__name__, args))
    return log_Func

def add(x, y):
    return x + y

def sub(x, y):
    return x - y

def div(x, y):
    return x // y

def mul(x, y):
    return x * y

func_add = logger(add)
func_sub = logger(sub)
func_div = logger(div)
func_mul = logger(mul)

func_add(10, 5)
func_sub(3, 1)
func_div(14, 7)
func_mul(99, 7)