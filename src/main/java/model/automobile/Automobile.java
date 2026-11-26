package model.automobile;

import java.util.Comparator;

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

    public static final Comparator<Automobile> BY_MODEL =
            Comparator.comparing(Automobile::getModel);

    public static final Comparator<Automobile> BY_YEAR =
            Comparator.comparingInt(Automobile::getYear);

    public static final Comparator<Automobile> BY_POWER =
            Comparator.comparingDouble(Automobile::getEnginePower);
}
