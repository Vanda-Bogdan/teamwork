package filereader;

@FunctionalInterface
public interface FileReader<B> {
    void readData(B builder);
}