package model.display;

import java.util.Comparator;

public class Display {
    private String model;
    private double diagonal;
    private int refreshRate;

    Display(String model, double diagonal, int refreshRate) {
        this.model = model;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
    }

    public Display() {
    }

    @Override
    public String toString() {
        return String.format("Модель: %-15s | Диагональ: %.1f | Частота: %d Гц",
                model, diagonal, refreshRate);
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

    //уберу реализацию интерфейса Comparable таким способом
    /*@Override
    public int compareTo(Display other) {
        return Comparator.comparing(Display::getModel)
                .thenComparingDouble(Display::getDiagonal)
                .thenComparingInt(Display::getRefreshRate)
                .compare(this, other);
    }*/

    public static final Comparator<Display> BY_MODEL =
            Comparator.comparing(Display::getModel);

    public static final Comparator<Display> BY_DIAGONAL =
            Comparator.comparingDouble(Display::getDiagonal);

    public static final Comparator<Display> BY_REFRESH_RATE =
            Comparator.comparingInt(Display::getRefreshRate);


    public static final Comparator<Display> DEFAULT_SORT =
            BY_MODEL
                    .thenComparing(BY_DIAGONAL)
                    .thenComparing(BY_REFRESH_RATE);
}
