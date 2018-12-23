const users = [
  {name: 'chnbin', id: 1},
  {name: 'chris', id: 2},
  {name: 'Kohiruimaki', id: 3},
  {name: 'chris', id: 4},
];

// Only find the first while condition is matched.
const user = users.find((user) => {
  return user.name === 'chris';
});

console.log(user);
