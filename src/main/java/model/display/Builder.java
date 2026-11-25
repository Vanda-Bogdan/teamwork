package model.display;

public interface Builder {
    Builder setModel(String model);
    Builder setDiagonal(double diagonal);
    Builder setRefreshRate(int refreshRate);
    void reset();
}
