package model.display;

import java.util.Comparator;

public class Display implements Comparable<Display>{
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


    @Override
    public int compareTo(Display other) {
        return Comparator.comparing(Display::getModel)
                .thenComparingDouble(Display::getDiagonal)
                .thenComparingInt(Display::getRefreshRate)
                .compare(this, other);
    }
}
