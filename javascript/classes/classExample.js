class Car {
  constructor(options) {
    this.title = options.title;
  }

  drive() {
    return 'vroom';
  }
}

const car = new Car({title: 'Corsa'});
console.log(car.drive());
console.log(car);
