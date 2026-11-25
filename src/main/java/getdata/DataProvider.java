package getdata;

import java.util.List;

public class DataProvider<T> {

    private GetDataStrategy<T> strategy;

    public void setStrategy(GetDataStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public List<T> getData () {

        if (strategy == null) {
            throw new IllegalStateException("Стратегия получения данных не задана.");
        }

        return this.strategy.getData();
    }
}
