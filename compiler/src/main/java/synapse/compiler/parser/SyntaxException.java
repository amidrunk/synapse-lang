package synapse.compiler.parser;

public class SyntaxException extends Exception {

    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
}
