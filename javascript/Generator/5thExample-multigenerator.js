function * foo() {
  const x = yield 2;
  z++;
  const y = yield (x * z);
  console.log(x, y, z);
}

let z = 1;

const it1 = foo();
const it2 = foo();

let val1 = it1.next().value;
console.log(val1);

let val2 = it2.next().value;
console.log(val2);

val1 = it1.next(val2 * 10).value;
console.log(val1);
val2 = it2.next(val1 * 5).value;
console.log(val2);

it1.next(val2/2);
it2.next(val1/4);


