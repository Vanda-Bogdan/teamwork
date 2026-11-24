package model.display;

import model.EntityBuilder;

import java.util.List;

public class DisplayBuilder implements EntityBuilder<Display>, Builder {

    private String model;
    private double diagonal;
    private int refreshRate;

    @Override
    public Display build() {

        //todo это перенести в валидацию
//        if(model == null || model.isBlank())
//            throw new IllegalStateException("Модель дисплея не может быть незаполненной");
//
//        if (diagonal <= 0)
//            throw new IllegalStateException("Диагональ дисплея не может быть 0 или меньше 0");
//
//        if (refreshRate <= 0)
//            throw new IllegalStateException("Частота обновления дисплея не может быть 0 или меньше 0");

        return new Display(model, diagonal, refreshRate);
    }

    @Override
    public DisplayBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public DisplayBuilder setDiagonal(double diagonal) {
        this.diagonal = diagonal;
        return this;
    }

    @Override
    public DisplayBuilder setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
        return this;
    }

    @Override
    public void reset() {
        this.model = null;
        this.diagonal = 0.0;
        this.refreshRate = 0;
    }
}
