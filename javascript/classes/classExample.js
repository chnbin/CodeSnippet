
/**
 * @param {Car} options
 */
function Car(options) {
  this.name = options.name;
  this.company = options.company;
}

Car.prototype.drive = () => {
  return `Boom~~~`;
};
const car = new Car({name: 'Focus', company: 'Ford'});

console.log(car);
console.log(car.drive());

/**
 * @param {Opel} options
 */
function Opel(options) {
  Car.call(this, options);
  this.color = options.color;
}
const corsa = new Opel({color: 'white', company: 'opel', name: 'corsa'});
console.log(corsa);
