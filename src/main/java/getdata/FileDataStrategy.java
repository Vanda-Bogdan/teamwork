package getdata;

import java.util.List;

public class FileDataStrategy implements GetDataStrategy<T> {


    @Override
    public List<T> getData() {
        return List.of();
    }
}
