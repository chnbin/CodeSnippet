let x = 1;

function *foo() {
  x++;
  yield; // pause
  console.log("x:", x);
}

function bar() {
  x++;
}

let it = foo();
it.next();
console.log(x);
bar();
console.log(x);
it.next();