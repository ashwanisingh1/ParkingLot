package model;

public class ParkingSlot {

    private Vehicle vehicle;
    private Integer slotNumber;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }


    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void emptySlot() {
        this.vehicle = null;
    }

    public boolean isSlotFree() {
        if (vehicle == null) {
            return true;
        }
        return false;
    }

}
