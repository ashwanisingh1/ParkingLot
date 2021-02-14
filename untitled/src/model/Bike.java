package model;

public class Bike extends Vehicle {

    private final Integer CONST_FEES = 100;

    public Bike() {
        super();
    }

    public Bike(String regNumber, Integer entryTime, Integer exitTime) {
        super(regNumber, entryTime, exitTime);
    }

    @Override
    public Integer calculateCharges() {
        return (getExitTime()-getEntryTime())*CONST_FEES;
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }
}
