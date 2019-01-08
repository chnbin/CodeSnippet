let Car = function(_color) {
  if (!new.target) throw 'Car() should be called with new';
  this.color = _color;
  // First method to add method in class.
  this.setColor = function(color) {
    this.color = color;
  };

  // second method to add method in class.
  Car.prototype.getColor = function() {
    return this.color;
  };
};

const car = new Car('red');

console.log(car._color); // undefined
console.log(car.getColor());

Object.prototype.toString = function() {
  return `color: ${this.color}`;
}

console.log(car.toString());
let c = {
  value: 1,
  color: 'blue',
}

console.log(c.toString());
