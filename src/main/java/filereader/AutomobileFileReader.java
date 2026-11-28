package filereader;

import model.automobile.AutomobileBuilder;
import java.io.BufferedReader;

public class AutomobileFileReader extends AbstractFileReader<AutomobileBuilder> {

    public AutomobileFileReader(BufferedReader reader) {
        super(reader);
    }

    @Override
    protected void fill(AutomobileBuilder builder, String text, double decimal, int integer) {
        builder.setModel(text)
                .setEnginePower(decimal)
                .setYear(integer);
    }
}
