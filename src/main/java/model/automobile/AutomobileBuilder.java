package model.automobile;

import model.EntityBuilder;

public class AutomobileBuilder implements EntityBuilder<Automobile> {

    private String model;
    private double enginePower;
    private int year;

    @Override
    public Automobile build() {
        return new Automobile(model, enginePower, year);
    }

    public AutomobileBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public AutomobileBuilder setEnginePower(double enginePower) {
        this.enginePower = enginePower;
        return this;
    }

    public AutomobileBuilder setYear(int year) {
        this.year = year;
        return this;
    }
}
