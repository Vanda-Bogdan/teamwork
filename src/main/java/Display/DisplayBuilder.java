package Display;

public class DisplayBuilder implements Builder {
    private String model;
    private double diagonal;
    private int refreshRate;

    public Display build() {
        if(model == null || model.isBlank())
            throw new IllegalStateException("Модель дисплея не может быть незаполненной");

        if (diagonal <= 0)
            throw new IllegalStateException("Диагональ дисплея не может быть 0 или меньше 0");

        if (refreshRate <= 0)
            throw new IllegalStateException("Частота обновления дисплея не может быть 0 или меньше 0");

        return new Display(model, diagonal, refreshRate);

    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    @Override
    public void reset() {
        this.model = null;
        this.diagonal = 0.0;
        this.refreshRate = 0;
    }
}
