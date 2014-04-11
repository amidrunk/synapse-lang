package synapse.compiler.parser;

import synapse.lang.model.Element;

import java.io.IOException;
import java.io.InputStream;

public interface Parser {

    void parse(ParserDelegate parserDelegate, InputStream in, String encoding) throws IOException, SyntaxException;

}
