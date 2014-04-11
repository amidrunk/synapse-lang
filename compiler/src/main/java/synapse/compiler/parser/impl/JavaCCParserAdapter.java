package synapse.compiler.parser.impl;

import synapse.compiler.parser.Parser;
import synapse.compiler.parser.ParserDelegate;
import synapse.compiler.parser.SyntaxException;
import synapse.lang.model.Element;

import java.io.IOException;
import java.io.InputStream;

public final class JavaCCParserAdapter implements Parser {

    @Override
    public void parse(ParserDelegate parserDelegate, InputStream in, String encoding) throws IOException, SyntaxException {
        try {
            new SynapseParser(parserDelegate, in, encoding).Root();
        } catch (ParseException e) {
            throw new SyntaxException(e.getMessage(), e);
        }
    }
}
