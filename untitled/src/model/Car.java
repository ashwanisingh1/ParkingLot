package model;

public class Car extends Vehicle {

    private final Integer CONST_FEES = 300;

    public Car() {
        super();
    }

    public Car(String regNumber, Integer entryTime, Integer exitTime) {
        super(regNumber, entryTime, exitTime);
    }

    @Override
    public Integer calculateCharges() {
        return (getExitTime()-getEntryTime())*CONST_FEES;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}
