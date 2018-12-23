// A simple Array.forEach example 1
const colors = ['red', 'green', 'blue'];

// Tranditional loop
for (let i = 0; i < colors.length; i++) {
  console.log(colors[i]);
}

// Foreach
colors.forEach((color) => {
  console.log(color);
});

// A simple Array.forEach example 2
const nums = [1, 2, 3, 4, 5, 6, 7, 8];
let sum = 0;

nums.forEach((num) => {
  sum += num;
});

console.log(`Sum of nums: ${sum}`);

// You can do like this....
function adder(num) {
  sum += num;
}

sum = 0;

nums.forEach(adder);
console.log(`Sum of nums: ${sum}`);