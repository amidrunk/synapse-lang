package synapse.compiler.parser;

import java.io.IOException;
import java.io.InputStream;

public interface Parser {

    void parse(InputStream in, String encoding) throws IOException, SyntaxException;

}
