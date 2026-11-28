package datareader;

@FunctionalInterface
public interface ConsoleReader<B> {
    void readData(B builder);
}