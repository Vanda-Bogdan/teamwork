package filereader;

import model.product.ProductBuilder;

import java.io.BufferedReader;

public class ProductFileReader extends AbstractFileReader<ProductBuilder> {

    public ProductFileReader(BufferedReader reader) {
        super(reader);
    }

    @Override
    protected void fill(ProductBuilder builder, String text, double decimal, int integer) {
        builder.setName(text)
                .setPrice(decimal)
                .setQuantity(integer);
    }

}
