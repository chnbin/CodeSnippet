class ParkingSystem {
    int[] capacity;
    
    public ParkingSystem(int big, int medium, int small) {
        capacity = new int[4];
        capacity[1] = big;
        capacity[2] = medium;
        capacity[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (capacity[carType] > 0) {
            capacity[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
