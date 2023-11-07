class ParkingSystem {
    
    public List<Integer> bigSlots = new ArrayList<>();
    public List<Integer> mediumSlots = new ArrayList<>();
    public List<Integer> smallSlots = new ArrayList<>();
    public int maxBigSlot;
    public int maxMediumSlot;
    public int maxSmallSlot;

    public ParkingSystem(int big, int medium, int small) {
        maxBigSlot = big;
        maxMediumSlot = medium;
        maxSmallSlot = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1 && bigSlots.size() < maxBigSlot) {
            bigSlots.add(carType);
            return true;
        }
        if (carType == 2 && mediumSlots.size() < maxMediumSlot) {
            mediumSlots.add(carType);
            return true;
        }
        if (carType == 3 && smallSlots.size() < maxSmallSlot) {
            smallSlots.add(carType);
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