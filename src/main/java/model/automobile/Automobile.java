package model.automobile;

public class Automobile {
    private String model;
    private double enginePower;
    private int year;

    public Automobile(String model, double enginePower, int year) {
        this.model = model;
        this.enginePower = enginePower;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public int getYear() {
        return year;
    }
}
