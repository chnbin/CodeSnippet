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
/**
 * Add num to sum
 * @param {number} num post.
 */
function adder(num) {
  sum += num;
}

sum = 0;

nums.forEach(adder);
console.log(`Sum of nums: ${sum}`);

// A simple Array.forEach example 3
const images = [
  {height: 1024, width: 768},
  {height: 800, width: 600},
  {height: 1320, width: 976},
];

const areas = [];

images.forEach((image)=>{
  areas.push(image.height * image.width);
});

console.log(areas);
