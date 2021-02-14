package model;


public abstract class Vehicle {

    private String regNumber;

    private Integer entryTime;

    private Integer exitTime;

    public Vehicle() {
    }

    public Vehicle(String regNumber, Integer entryTime, Integer exitTime) {
        this.regNumber = regNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Integer getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Integer entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getExitTime() {
        return exitTime;
    }

    public void setExitTime(Integer exitTime) {
        this.exitTime = exitTime;
    }

    public abstract Integer calculateCharges();

    public abstract String getVehicleType();

}
