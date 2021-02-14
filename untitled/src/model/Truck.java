package model;

public class Truck extends Vehicle {

    private final Integer CONST_FEES = 1000;

    public Truck() {
        super();
    }

    public Truck(String regNumber, Integer entryTime, Integer exitTime) {
        super(regNumber, entryTime, exitTime);
    }

    @Override
    public Integer calculateCharges() {
        return (getExitTime()-getEntryTime())*CONST_FEES;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }

}
