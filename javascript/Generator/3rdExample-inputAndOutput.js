function *foo(x, y) {
  return x*y;
}

const lt = foo(6, 7);
const res = lt.next();
console.log(res.value);
