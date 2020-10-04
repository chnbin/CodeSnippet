class ParkingSystem {
    capacity: number[];
    constructor(big: number, medium: number, small: number) {
        this.capacity = [0, 0, 0, 0];
        this.capacity[1] = big;
        this.capacity[2] = medium;
        this.capacity[3] = small;
    }

    addCar(carType: number): boolean {
        if (this.capacity[carType] > 0) {
            this.capacity[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = new ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */
 