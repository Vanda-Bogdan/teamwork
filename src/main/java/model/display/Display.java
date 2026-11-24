package model.display;

public class Display {
    private String model;
    private double diagonal;
    private int refreshRate;

    Display(String model, double diagonal, int refreshRate) {
        this.model = model;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
    }

    public String getModel() {
        return model;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getRefreshRate() {
        return refreshRate;
    }


}
