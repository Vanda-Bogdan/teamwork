package datareader;

@FunctionalInterface
public interface DataReader<B> {
    void readData(B builder);
}