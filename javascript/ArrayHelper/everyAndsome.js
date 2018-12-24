const computers = [
  {name: 'Apple', ram: 8},
  {name: 'Dell', ram: 16},
  {name: 'Hp', ram: 4},
];

const isAllGreatThan8GMemory = computers.every((computer) => {
  return computer.ram >= 8;
});

console.log(isAllGreatThan8GMemory);

const isSomeComputerGreatThan8GMemory = computers.some((computer) => {
  return computer.ram >= 8;
});

console.log(isSomeComputerGreatThan8GMemory);

/**
 * Setting a field with value.
 * @param {string} value post.
 */
function Field(value) {
  this.value = value;
}

const name = new Field('chnbin');
const pwd = new Field('******');
const birthDay = new Field('1977/01/26');

Field.prototype.validate = function() {
  return this.value.length > 0;
};

console.log(name.validate() && pwd.validate() && birthDay.validate());

fields = [name, pwd, birthDay];

const isFormValidate = fields.every((field) => {
  return field.value.length > 0;
});

console.log(isFormValidate);

if (isFormValidate) {
  // Do something...
} else {
  // Show warning...
}
