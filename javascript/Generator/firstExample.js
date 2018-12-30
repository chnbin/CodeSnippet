function nums() {
};

// Undefine
console.log(nums());

function *numsGenerator() {

}

// A object
console.log(numsGenerator());

function *numsGenerator2() {
  yield;
}

const g = numsGenerator2();
g.next();
console.log(g);
g.next();
console.log(g);

