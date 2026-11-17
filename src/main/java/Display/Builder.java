package Display;

public interface Builder {
    void setModel(String model);
    void setDiagonal(double diagonal);
    void setRefreshRate(int refreshRate);
    void reset();
}
