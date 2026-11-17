package Display;

public class Director {

    public void constructTest1(Builder builder) {
        builder.setDiagonal(13.6);
        builder.setModel("Apple MacBook Air M5");
        builder.setRefreshRate(60);
    }

    public void constructTest2(Builder builder) {
        builder.setDiagonal(13.6);
        builder.setModel("Apple MacBook Air M5");
        builder.setRefreshRate(60);
    }

    public void constructTest3(Builder builder) {
        builder.setDiagonal(16);
        builder.setModel("HONOR MagicBook X16 AMD 2025");
        builder.setRefreshRate(60);
    }

}
